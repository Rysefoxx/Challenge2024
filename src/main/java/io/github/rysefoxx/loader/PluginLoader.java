package io.github.rysefoxx.loader;

import io.papermc.paper.plugin.loader.PluginClasspathBuilder;
import io.papermc.paper.plugin.loader.library.impl.MavenLibraryResolver;
import org.eclipse.aether.artifact.DefaultArtifact;
import org.eclipse.aether.graph.Dependency;
import org.eclipse.aether.repository.RemoteRepository;
import org.jetbrains.annotations.NotNull;

/**
 * @author Rysefoxx
 * @since 01.05.2024
 */
@SuppressWarnings({"UnstableApiUsage", "unused"})
public class PluginLoader implements io.papermc.paper.plugin.loader.PluginLoader {

    @Override
    public void classloader(@NotNull PluginClasspathBuilder classpathBuilder) {
        MavenLibraryResolver resolver = new MavenLibraryResolver();
        resolver.addDependency(new Dependency(new DefaultArtifact("org.jetbrains.kotlin:kotlin-stdlib:1.9.23"), null));
        resolver.addDependency(new Dependency(new DefaultArtifact("net.axay:kspigot:1.20.3"), null));
        resolver.addDependency(new Dependency(new DefaultArtifact("dev.jorel:commandapi-bukkit-shade:9.4.0"), null));
        resolver.addDependency(new Dependency(new DefaultArtifact("com.charleskorn.kaml:kaml:0.58.0"), null));
        resolver.addRepository(new RemoteRepository.Builder("central", "default", "https://repo1.maven.org/maven2/").build());

        classpathBuilder.addLibrary(resolver);
    }
}