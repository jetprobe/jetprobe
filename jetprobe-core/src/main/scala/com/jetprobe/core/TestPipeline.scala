package com.jetprobe.core


import java.util.function.Consumer

import com.jetprobe.core.structure.{ExecutablePipeline, PipelineBuilder}
import com.jetprobe.core.validations.{Passed, ValidationResult}
import com.typesafe.scalalogging.LazyLogging
import org.json4s.DefaultFormats
import wvlet.log.LogSupport

import scala.util.{Failure, Success, Try}

/**
  * @author Shad.
  */
trait TestPipeline extends CoreDsl with LogSupport {

  implicit val formats = DefaultFormats

  /**
    * Define the list of task that needs to be executed as part of the test suite
    * @return The Scenario consisting of list of tasks
    */
  def tasks : PipelineBuilder

  def assertEquals[T](expected : T,actual : => sourcecode.Text[T])(implicit line: sourcecode.Line, fullName: sourcecode.FullName) : ValidationResult = {
    val returnedVal = Try(actual.value)
    returnedVal match {
      case Success(v) if v == expected => ValidationResult.success()
      case Success(v) if v != expected =>
        throw new Exception(s"Expression : ${actual.source} at ${fullName.value}:${line.value} evaulated as : ${actual.value}, but expected : ${expected}")
      case Failure(ex) =>
        throw new IllegalArgumentException(s"Expression at ${fullName.value}:${line.value} failed to evaluate with exception : ${ex.getMessage}")
    }
  }

  def assertTrue(actual : => sourcecode.Text[Boolean])(implicit line: sourcecode.Line, fullName: sourcecode.FullName) : ValidationResult = {
    assertEquals(true,actual)
  }


}

abstract class JTestPipeline extends TestPipeline