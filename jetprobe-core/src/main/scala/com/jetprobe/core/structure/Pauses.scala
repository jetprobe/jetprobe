package com.jetprobe.core.structure

import com.jetprobe.core.task.builder.PauseTaskBuilder

import scala.concurrent.duration.FiniteDuration

/**
  * @author Shad.
  */
trait Pauses[B] extends Execs[B]{

  def pause(description : String, duration : FiniteDuration) : B = exec(new PauseTaskBuilder(description,duration))

}
