package dev.brgr.schellihomeservice.growtimer;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.library.Architectures;
import dev.brgr.schellihomeservice.growtimer.core.service.LightOperatorService;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClass;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = {"dev.brgr.schellihomeservice.growtimer"},
importOptions = {ImportOption.DoNotIncludeTests.class})
public class ArchitectureTest {

    public static final String GROWTIMER_PACKAGE = "dev.brgr.schellihomeservice.growtimer";

    @Test
    public void testBasicLayerArchitecture(){
        JavaClasses importedClasses = new ClassFileImporter().withImportOption(new ImportOption.DoNotIncludeTests())
                .importPackages(GROWTIMER_PACKAGE);

        Architectures.LayeredArchitecture layeredArchitecture = layeredArchitecture()
                .layer("application").definedBy(GROWTIMER_PACKAGE + ".application..")
                .layer("core").definedBy(GROWTIMER_PACKAGE + ".core..")
                .layer("infrastructure").definedBy(GROWTIMER_PACKAGE + ".infrastructure..")
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
