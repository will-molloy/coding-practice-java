package com.wilmol.hackerrank.common;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Created by Will on 26/03/2019
 */
@RequiredArgsConstructor(staticName = "of")
@Data
public class SinglyLinkedListNode
{

  public final int data;

  public SinglyLinkedListNode next;

}
