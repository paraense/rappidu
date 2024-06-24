package br.com.rappidu;


import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packages = "br.com.rappidu")
public class InfraArchitectureHexagonalTest {

    @ArchTest
    public static final ArchRule shouldNotHaveImportedClassFromApplicationPackage = noClasses()
            .that().resideInAnyPackage("..infra..")
            .should()
            .dependOnClassesThat()
            .resideInAPackage("..application..");
}
