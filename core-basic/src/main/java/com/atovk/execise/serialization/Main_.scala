package com.atovk.execise.serialization

object Main_ {

  def main(args: Array[String]): Unit = {
    val task_ = new SimpleTask("xiaoming")
    FileSerializer.writeObject(task_, "task.ser")
  }

}
