package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-11-27 17:07
 **/
public class Problem133 {
    private static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


    // Runtime: 25 ms, faster than 89.07% of Java online submissions for Clone Graph.
    //Memory Usage: 39.4 MB, less than 20.59% of Java online submissions for Clone Graph.
    Map<Integer, Node> nodes = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        Node cloneNode = nodes.get(node.val);
        if (cloneNode == null) {
            cloneNode = new Node(node.val);
            nodes.put(node.val, cloneNode);
            for (Node neighbor : node.neighbors) {
                Node neibor = cloneGraph(neighbor);
                if (!neibor.neighbors.contains(cloneNode))
                    neibor.neighbors.add(cloneNode);
            }
        }

        return cloneNode;
    }
}
