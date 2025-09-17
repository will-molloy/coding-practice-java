package com.willmolloy.adventofcode.scala

import com.willmolloy.adventofcode.common.grid.{CharGrid, MutableCharGrid, Point}

import scala.collection.immutable.ArraySeq
import scala.jdk.CollectionConverters.IteratorHasAsScala
import scala.jdk.CollectionConverters.ListHasAsScala
import scala.language.implicitConversions

object Adapters {

  implicit def ListAdapter[T](list: java.util.List[T]): IndexedSeq[T] = list.asScala.toIndexedSeq

  implicit def ArrayAdapter[T](array: Array[T]): ArraySeq[T] = ArraySeq.unsafeWrapArray(array)

  implicit class GridAdapter(grid: CharGrid) extends Iterable[Point] {
    @throws[ArrayIndexOutOfBoundsException]
    def apply(point: Point): Char = grid.get(point)

    override def iterator: Iterator[Point] = grid.iterator().asScala
  }

  implicit class MutableGridAdapter(grid: MutableCharGrid) {
    @throws[ArrayIndexOutOfBoundsException]
    def update(point: Point, c: Char): Unit = grid.set(point, c)
  }
}
