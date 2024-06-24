package br.com.rappidu;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Service;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;


@AnalyzeClasses(packages = "br.com.rappidu")
public class DomainArchitectureHexagonalTest {

    @ArchTest
    public static final ArchRule shouldNotHaveImportedClassesWithoutDomain = classes()
            .that()
            .resideInAPackage("..domain..")
            .should()
            .onlyDependOnClassesThat()
            .resideInAnyPackage("..java..", "..domain..");

    @ArchTest
    public static final ArchRule shouldNotHaveAnnotationInDomainClasses = classes()
            .that()
            .resideInAPackage( "..domain..")
            .should()
            .notBeAnnotatedWith(Service.class);
}
