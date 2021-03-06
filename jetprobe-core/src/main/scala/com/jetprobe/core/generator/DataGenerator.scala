package com.jetprobe.core.generator

import com.jetprobe.core.Predef.Session
import com.jetprobe.core.structure.PipelineContext

/**
  * @author Shad.
  */
trait DataGenerator {

  def generate(session: Session) : Option[Iterator[String]]


}
