package exercises

import stdlib._
import shapeless.HNil

import org.scalatest.Spec
import org.scalatest.prop.Checkers

// FIXME: get rid of this if possible
import org.scalacheck.Shapeless._

class AssertsSpec extends Spec with Checkers {
  def `scalatest asserts` = {
    check(Test.success(Asserts.scalaTestAsserts _, true :: HNil))
  }

  // FIXME: depends on #259
  // check(success(Asserts.booleansAsserts _, HNil))

  def `values asserts` = {
    check(Test.success(Asserts.valuesAsserts _, 2 :: HNil))
  }
}

class ByNameParameterSpec extends Spec with Checkers {
  def `takes unit by name parameter` = {
    val right: Either[Throwable, Int] = Right(29)

    check(
      Test.success(
        ByNameParameter.takesUnitByNameParameter _,
        right :: HNil
      )
    )
  }

  def `takes parameters by name` = {
    val right: Either[Throwable, Int] = Right(69)

    check(
      Test.success(
        ByNameParameter.byNameParameter _,
        right :: HNil
      )
    )
  }

  def `apply parameters` = {
    check(
      Test.success(
        ByNameParameter.withApplyByNameParameter _,
        "retzelpay" :: HNil
      )
    )
  }
}

class CaseClassesSpec extends Spec with Checkers {
  def `case classes comparisons` = {
    check(
      Test.success(
        CaseClasses.caseClassesSupportEquality _,
        false :: true :: false :: false :: HNil
      )
    )
  }

  def `hash codes` = {
    check(
      Test.success(
        CaseClasses.hashcodeMethodCaseClasses _,
        false :: true :: HNil
      )
    )
  }

  def `case class creation` = {
    check(
      Test.success(
        CaseClasses.creationCaseClasses _,
        true :: false :: false :: HNil
      )
    )
  }

  def `to string method` = {
    check(
      Test.success(
        CaseClasses.toStringMethodCaseClasses _,
        "Dog(Scooby,Doberman)" :: HNil
      )
    )
  }

  def `properties` = {
    check(
      Test.success(
        CaseClasses.propertiesCaseClasses _,
        "Scooby" :: "Doberman" :: HNil
      )
    )
  }

  def `mutable properties` = {
    check(
      Test.success(
        CaseClasses.mutablePropertiesCaseClasses _,
        "Scooby" :: "Doberman" :: "Scooby Doo" :: "Doberman" :: HNil
      )
    )
  }

  def `altering case classes` = {
    check(
      Test.success(
        CaseClasses.alteringCaseClasses _,
        "Scooby" :: "Doberman" :: "Scooby Doo" :: "Doberman" :: HNil
      )
    )
  }

  // FIXME: Shapeless doesn't find an implicit FnToProduct.Aux, why?
  // def `case class parameters` = {
  //   check(
  //     Test.success(
  //       CaseClasses.parametersCaseClasses _,
  //       "Fred" :: "Jones" :: 23 :: "111-22-3333" ::
  //         "Samantha" :: "Jones" :: 0 :: "111-22-3333" ::
  //         "Fred" :: "Jones" :: 0 :: "111-22-3333" ::
  //         "Fred" :: "Jones" :: 23 :: "111-22-3333" :: HNil
  //     )
  //   )
  // }

  def `case classes as tuples` = {
    check(
      Test.success(
        CaseClasses.asTupleCaseClasses _,
        "Fred" :: "Jones" :: 23 :: "111-22-3333" :: HNil
      )
    )
  }

  def `case classes are serializable` = {
    check(
      Test.success(
        CaseClasses.serializableCaseClasses _,
        true :: false :: HNil
      )
    )
  }
}

class ClassesSpec extends Spec with Checkers {

  def `classes with val parameters` = {
    check(
      Test.success(
        Classes.classWithValParameterClasses _,
        "Gandalf" :: HNil
      )
    )
  }

  def `classes with var parameters` = {
    check(
      Test.success(
        Classes.classWithVarParameterClasses _,
        "Flying character" :: "Flying white character" :: HNil
      )
    )
  }
}

class ConstructorsSpec extends Spec with Checkers {
  def `primary constructor` = {
    check(
      Test.success(
        Constructors.primaryConstructorConstructors _,
        "defaultname" :: HNil
      )
    )
  }
}

class EmptyValuesSpec extends Spec with Checkers {
  def `empty values` = {
    check(
      Test.success(
        EmptyValues.emptyValuesEmptyValues _,
        true :: HNil
      )
    )
  }

  def `none is equal to none` = {
    check(
      Test.success(
        EmptyValues.avoidingNullEmptyValues _,
        true :: HNil
      )
    )
  }

  def `none is identical to none` = {
    check(
      Test.success(
        EmptyValues.identicalNoneEmptyValues _,
        true :: HNil
      )
    )
  }

  def `none to string` = {
    check(
      Test.success(
        EmptyValues.noneToStringEmptyValues _,
        "None" :: HNil
      )
    )
  }

  def `none to list` = {
    check(
      Test.success(
        EmptyValues.noneToListEmptyValues _,
        true :: HNil
      )
    )
  }

  def `none is empty` = {
    check(
      Test.success(
        EmptyValues.noneToListEmptyValues _,
        true :: HNil
      )
    )
  }

  def `none can be casted` = {
    check(
      Test.success(
        EmptyValues.noneToAnyEmptyValues _,
        true :: true :: true :: HNil
      )
    )
  }

  def `none is an option` = {
    val theOption: Option[String] = None

    check(
      Test.success(
        EmptyValues.noneWithOptionEmptyValues _,
        true :: theOption :: HNil
      )
    )
  }

  def `some vs none` = {
    check(
      Test.success(
        EmptyValues.someAgainstNoneEmptyValues _,
        false :: false :: HNil
      )
    )
  }

  def `getOrElse on none` = {
    check(
      Test.success(
        EmptyValues.getOrElseEmptyValues _,
        "Some Value" :: "No Value" :: HNil
      )
    )
  }
}

class EnumerationsSpec extends Spec with Checkers {
  def `create enumerations` = {
    check(
      Test.success(
        Enumerations.createEnumerationEnumerations _,
        0 :: 1 :: "Mercury" :: "Venus" :: true :: false :: HNil
      )
    )
  }

  def `create enumerations with custom indices` = {
    check(
      Test.success(
        Enumerations.ownIndexEnumerations _,
        1 :: 2 :: "Hermes" :: "Aphrodite" :: true :: false :: HNil
      )
    )
  }

  def `create enumerations in one line` = {
    check(
      Test.success(
        Enumerations.oneLineEnumerations _,
        0 :: 1 :: "Mercury" :: "Venus" :: true :: false :: HNil
      )
    )
  }

  def `create enumerations from strings` = {
    check(
      Test.success(
        Enumerations.stringValueEnumerations _,
        0 :: 1 :: "Hermes" :: "Aphrodite" :: true :: false :: HNil
      )
    )
  }

  def `extending enumerations` = {
    check(
      Test.success(
        Enumerations.extendingValueEnumerations _,
        5.976e+24 :: 6.37814e6 :: HNil
      )
    )
  }
}

class ExtractorsSpec extends Spec with Checkers {
  def `extractors` = {
    check(
      Test.success(
        Extractors.extractorsExtractors _,
        "Where's Batman?" :: HNil
      )
    )
  }

  def `unapply` = {
    check(
      Test.success(
        Extractors.calledUnapplyExtractors _,
        "Chevy" :: "Camaro" :: 1978 :: 120 :: HNil
      )
    )
  }

  def `pattern matching` = {
    check(
      Test.success(
        Extractors.patternMatchingExtractors _,
        "Chevy" :: "Camaro" :: HNil
      )
    )
  }

  def `wildcards` = {
    check(
      Test.success(
        Extractors.withWildcardExtractors _,
        "Chevy" :: "Camaro" :: HNil
      )
    )
  }

  def `multiple extractors` = {
    check(
      Test.success(
        Extractors.multipleUnapplyExtractors _,
        "c: Kurt, d: Vonnegut" :: HNil
      )
    )
  }

  def `any object as extractor` = {
    check(
      Test.success(
        Extractors.anyObjectExtractors _,
        "make: Chevy, model: Camaro" :: HNil
      )
    )
  }

  def `extractor in companion object` = {
    val theOption: Option[String] = None

    check(
      Test.success(
        Extractors.asAssignmentExtractors _,
        "Keerthi" :: theOption :: "Singri" :: HNil
      )
    )
  }

  def `unapply for pattern matching extractors` = {
    check(
      Test.success(
        Extractors.unapplyForPatternMatchingExtractors _,
        "I don't care, going on break" :: HNil
      )
    )
  }
}