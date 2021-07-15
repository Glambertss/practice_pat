package leetcode;//

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

public class Solution {
    // . 代表识别一个字符， * 代表识别0个或者多个字符
    public boolean isMatch(String s, String p) {
        //如何决定pattern到下一个？
        char[] s_chars = s.toCharArray();
        char[] pattern_chars = p.toCharArray();

        int j = 1;
        for (int i = 0; i < pattern_chars.length; i++) {

            if (pattern_chars[i] == s_chars[0] || pattern_chars[i] == '.') {
                j = i;
                break;
            } else {
                if (i + 1 < pattern_chars.length) {
                    if (pattern_chars[i + 1] == '*') {
                        i += 1;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        Node matchHead = new Node(pattern_chars[j]);
        Node currentNode = matchHead;
        Node pattern_tail = null;

        for (int i = j + 1; i < pattern_chars.length; i++) {
            Node nodeToDeal = new Node(pattern_chars[i]);

            if (pattern_chars[i] == '*') {
                //需要考虑连续出现两个*
                currentNode.addNextNode(currentNode);
                currentNode.addPre(currentNode);
                continue;
            }
            //如果当前结点是自我循环结点
            if (currentNode.getPre().contains(currentNode)) {
                if (currentNode.s == nodeToDeal.s && currentNode.s != '.') {
                    //说明当前点和要处理的点的值相同，跳过到下一个
                    continue;
                } else {
                    //如果前面那个节点
                    ArrayList<Node> nodesToAddNextNode = new ArrayList<>();
                    for (Node node : currentNode.getPre()) {
                        if (node != currentNode) {
                            nodesToAddNextNode.add(node);
                        }
                    }
                    while (nodesToAddNextNode.size() > 0) {
                        Node nodeToAddNext = nodesToAddNextNode.get(0);
                        nodeToAddNext.addNextNode(nodeToDeal);
                        if (nodeToAddNext.getPre().contains(nodeToAddNext)) {
                            for (Node temp : nodeToAddNext.getPre()) {
                                if (temp != nodeToAddNext) {
                                    nodesToAddNextNode.add(temp);
                                }
                            }

                        }
                        nodesToAddNextNode.remove(nodeToAddNext);
                    }
                }
            }

           // if(currentNode.s == '.' && no)

            currentNode.addNextNode(nodeToDeal);
            nodeToDeal.addPre(currentNode);
            currentNode = nodeToDeal;

        }
        pattern_tail = currentNode;
        currentNode = matchHead;
        boolean isMatch = false;


        for (int k = 1; k < s_chars.length; k++) {
            //因为第一个已经匹配完成了，所以从原始串的第2个开始匹配
            isMatch = false;

            for (Node temp : currentNode.getNext()) {
                if (temp.s == '.' || temp.s == s_chars[k] ) {
                    isMatch = true;
                    currentNode = temp;
                    break;
                }
            }
            if (isMatch == false) {
                return false;
            }
        }
        if(currentNode == pattern_tail){
            return true;
        }else {
            //如果正则表达式最后的一个匹配字符是*
            if (currentNode.getNext().contains(currentNode)) {
                //如果s_chars最后的结点是通过 类似于a*进行匹配的
                while (currentNode != pattern_tail) {
                    isMatch = false;
                    for (Node node : currentNode.getNext()) {
                        if (node != currentNode && (node.s == '.' || s_chars[s_chars.length - 1] == node.s)) {
                            currentNode = node;
                            isMatch = true;
                            break;
                        }
                    }
                    if (isMatch == false) {
                        return false;

                    }

                }
            }
            else {
                //如果匹配的正则表达式最后不带*
                //查找最后一个结点的next里面是否有 指向自己的final结点
                //currentNode代表pattern里面匹配的最后一个结点，并且现在其不是自我循环结点
                boolean matchFlag = false;
                for (Node node : currentNode.getNext()) {

                    if ( node.getNext().contains(node)) {
                        //如果currentNode后面的结点有自我循环的结点，并且该结点是最后一个结点
                        if(node == pattern_tail) {
                            //当前结点是自我循环结点，并且当前结点是结束结点
                            matchFlag = true;
                            break;
                        }
                    }else{
                        //如果其后面结点是.或者是普通字符的话
                        //node.getPre()
                    }


                }
                return matchFlag;
            }
        }





        return true;

    }
    class Node {

        char s;
        CopyOnWriteArrayList<Node> pre = new CopyOnWriteArrayList<>();
        CopyOnWriteArrayList<Node> next = new CopyOnWriteArrayList<>();

        public Node() {
        }


        public CopyOnWriteArrayList<Node> getPre() {
            return pre;
        }

        public void addPre(Node node) {
            this.pre.add(node);
        }

        public Node(char s) {
            this.s = s;
        }

        public CopyOnWriteArrayList<Node> getNext() {
            return next;
        }

        public void setNext(CopyOnWriteArrayList<Node> next) {
            this.next = next;
        }

        public void addNextNode(Node node) {
            this.next.add(node);
        }


    }


}


