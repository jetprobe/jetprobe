package com.jetprobe.core.structure

import com.jetprobe.core.task.builder.RunCommandBuilder

/**
  * @author Shad.
  */
trait LocalCommands[B] extends Execs[B]{


  def runCmd(description : String, command : String, at : String = System.getProperty("user.home")) : B = exec(new RunCommandBuilder(description,command,at))

}