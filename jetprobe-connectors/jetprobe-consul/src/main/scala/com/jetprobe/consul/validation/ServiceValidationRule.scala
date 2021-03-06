package com.jetprobe.consul.validation

import com.jetprobe.consul.ConsulService
import com.jetprobe.consul.model.ServiceInfo
import com.jetprobe.core.validations.{ValidationResult, ValidationRule}
import sourcecode.{FullName, Line}

/**
  * @author Shad.
  */
case class ServiceValidationRule[U <: Any](expected: U,
                                           actual : ServiceInfo => U,

                                           service : String = "",
                                          name : String = ""
                                          )
  extends ValidationRule[ConsulService]{

  override def validate(config: Map[String, Any], storage: ConsulService): ValidationResult = ???

}

