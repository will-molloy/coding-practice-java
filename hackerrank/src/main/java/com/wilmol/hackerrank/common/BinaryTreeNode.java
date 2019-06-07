package com.wilmol.hackerrank.common;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Created by Will on 24/03/2019
 */
@RequiredArgsConstructor(staticName = "of")
@Data
public class BinaryTreeNode
{

  public final int data;

  public BinaryTreeNode left;

  public BinaryTreeNode right;

}
