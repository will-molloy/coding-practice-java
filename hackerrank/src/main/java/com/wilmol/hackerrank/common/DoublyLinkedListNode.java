package com.wilmol.hackerrank.common;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Created by Will on 28/03/2019
 */
@RequiredArgsConstructor(staticName = "of")
@EqualsAndHashCode(exclude = "prev")
@ToString(exclude = "prev")
@Data
public class DoublyLinkedListNode
{

  public final int data;

  public DoublyLinkedListNode next;

  public DoublyLinkedListNode prev;

}
