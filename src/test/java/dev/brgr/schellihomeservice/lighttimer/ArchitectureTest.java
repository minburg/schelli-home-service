package dev.brgr.schellihomeservice.lighttimer;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.library.Architectures;
import dev.brgr.schellihomeservice.lighttimer.core.service.LightOperatorService;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClass;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = {"dev.brgr.schellihomeservice.lighttimer"},
importOptions = {ImportOption.DoNotIncludeTests.class})
public class ArchitectureTest {

    public static final String LIGHTTIMER_PACKAGE = "dev.brgr.schellihomeservice.lighttimer";

    @Test
    public void testBasicLayerArchitecture(){
        JavaClasses importedClasses = new ClassFileImporter().withImportOption(new ImportOption.DoNotIncludeTests())
                .importPackages(LIGHTTIMER_PACKAGE);

        Architectures.LayeredArchitecture layeredArchitecture = layeredArchitecture()
                .layer("application").definedBy(LIGHTTIMER_PACKAGE + ".application..")
                .layer("core").definedBy(LIGHTTIMER_PACKAGE + ".core..")
                .layer("infrastructure").definedBy(LIGHTTIMER_PACKAGE + ".infrastructure..")
                .whereLayer("application").mayNotBeAccessedByAnyLayer()
                .whereLayer("core").mayOnlyBeAccessedByLayers("application", "infrastructure")
                .whereLayer("infrastructure").mayNotBeAccessedByAnyLayer();

        layeredArchitecture.check(importedClasses);
    }

    @Test
    public void noSpringDependenciesInCore(){
        noClass(LightOperatorService.class)
                .should()
                .dependOnClassesThat()
                .resideInAPackage("org.springframework..");
    }
}
