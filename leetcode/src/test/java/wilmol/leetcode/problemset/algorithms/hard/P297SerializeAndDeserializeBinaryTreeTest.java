package wilmol.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;
import wilmol.leetcode.common.BinaryTreeNode;

/** Created by wilmol on 2020-04-25. */
class P297SerializeAndDeserializeBinaryTreeTest {

  private final P297SerializeAndDeserializeBinaryTree p297 =
      new P297SerializeAndDeserializeBinaryTree();

  @Test
  void example() {
    BinaryTreeNode asTree = BinaryTreeNode.fromLevelOrder(1, 2, 3, null, null, 4, 5);
    String asString = "1(2)(3(4)(5))";
    assertThat(p297.serialize(asTree)).isEqualTo("1(2)(3(4)(5))");
    assertThat(p297.deserialize(asString)).isEqualTo(asTree);
  }
}
