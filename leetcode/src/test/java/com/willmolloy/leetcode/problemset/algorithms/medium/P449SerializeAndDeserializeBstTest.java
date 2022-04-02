package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.BinaryTreeNode;
import org.junit.jupiter.api.Test;

/**
 * P449SerializeAndDeserializeBstTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P449SerializeAndDeserializeBstTest {

  private final P449SerializeAndDeserializeBst fun = new P449SerializeAndDeserializeBst();

  @Test
  void oneNode() {
    BinaryTreeNode root = BinaryTreeNode.fromLevelOrder(1);
    String data = "1";
    assertThat(fun.serialize(root)).isEqualTo(data);
    assertThat(fun.deserialize(data)).isEqualTo(root);
  }

  @Test
  void twoNodesLeft() {
    BinaryTreeNode root = BinaryTreeNode.fromLevelOrder(2, 1);
    String data = "2(1)";
    assertThat(fun.serialize(root)).isEqualTo(data);
    assertThat(fun.deserialize(data)).isEqualTo(root);
  }

  @Test
  void twoNodesRight() {
    BinaryTreeNode root = BinaryTreeNode.fromLevelOrder(2, null, 3);
    String data = "2()(3)";
    assertThat(fun.serialize(root)).isEqualTo(data);
    assertThat(fun.deserialize(data)).isEqualTo(root);
  }

  @Test
  void threeNodes() {
    BinaryTreeNode root = BinaryTreeNode.fromLevelOrder(2, 1, 3);
    String data = "2(1)(3)";
    assertThat(fun.serialize(root)).isEqualTo(data);
    assertThat(fun.deserialize(data)).isEqualTo(root);
  }

  @Test
  void fourNodes() {
    BinaryTreeNode root = BinaryTreeNode.fromLevelOrder(2, 1, 3, null, null, null, 4);
    String data = "2(1)(3()(4))";
    assertThat(fun.serialize(root)).isEqualTo(data);
    assertThat(fun.deserialize(data)).isEqualTo(root);
  }

  @Test
  void leftLinkedList() {
    BinaryTreeNode root = BinaryTreeNode.fromLevelOrder(4, 3, null, 2, null, null, null, 1);
    String data = "4(3(2(1)))";
    assertThat(fun.serialize(root)).isEqualTo(data);
    assertThat(fun.deserialize(data)).isEqualTo(root);
  }

  @Test
  void rightLinkedList() {
    BinaryTreeNode root =
        BinaryTreeNode.fromLevelOrder(
            1, null, 2, null, null, null, 3, null, null, null, null, null, null, null, 4);
    String data = "1()(2()(3()(4)))";
    assertThat(fun.serialize(root)).isEqualTo(data);
    assertThat(fun.deserialize(data)).isEqualTo(root);
  }
}
