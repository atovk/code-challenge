package com.atovk.execise.serialization

object Main {

  def main(args: Array[String]): Unit = {

    val fileClassLoader = new FileClassLoader()
    val task: Task = FileSerializer.readObjectWithClassLoader("task.ser", fileClassLoader).asInstanceOf[Task]
    task.run()
  }
}
