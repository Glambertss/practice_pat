package hd_judge;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 输出wrong answer
 */
class NodeInfo{
    int x;
    int y;

    public NodeInfo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

enum Direction{
    UP(-1, 0, 'u'),
    DOWN(1, 0, 'd'),
    LEFT(0, -1, 'l'),
    RIGHT(0, 1, 'r');

    Direction(int xChange, int yChange) {
        this.xChange = xChange;
        this.yChange = yChange;
    }

    Direction(int xChange, int yChange, char signal) {
        this.xChange = xChange;
        this.yChange = yChange;
        this.signal = signal;
    }

    public int getxChange() {
        return xChange;
    }

    public int getyChange() {
        return yChange;
    }


    public char getSignal() {
        return signal;
    }

    private int xChange;
    private int yChange;
    private char signal;

}

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        while(N != 0 && M != 0 && scanner.hasNext()){
            Queue<NodeInfo> queue = new ConcurrentLinkedQueue<>();

            char[][] map = new char[M][N];
            int[][] pointVisited = new int[M][N];
            int count = 0;
            int index = 0;
            do {
                String temp = scanner.nextLine();
                if (!temp.equals("")) {
                    map[index++] = temp.toCharArray();

                }
            } while (index < M);

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if ('@' == map[i][j]) {
                        NodeInfo nodeInfo = new NodeInfo(i, j);
                        queue.add(nodeInfo);
                        pointVisited[nodeInfo.getX()][nodeInfo.getY()] = 1;
                        break;
                    }
                }
            }


            while (queue.size() > 0) {
                NodeInfo poll = queue.poll();
                count++;
                for (Direction value : Direction.values()) {
                    NodeInfo adjacdentNode = getAdjacdentNode(map, M, N, poll, value);
                    if (adjacdentNode != null && pointVisited[adjacdentNode.getX()][adjacdentNode.getY()] == 0) {
                        queue.add(adjacdentNode);
                        pointVisited[adjacdentNode.getX()][adjacdentNode.getY()] = 1;
                    }
                }
            }

            System.out.println(count);
             N = scanner.nextInt();
            M = scanner.nextInt();
        }
        scanner.close();

    }
    public static NodeInfo getAdjacdentNode(char[][] map, int M, int N, NodeInfo currentNode, Direction direction){
        NodeInfo nodeInfo = new NodeInfo(currentNode.getX() + direction.getxChange(), currentNode.getY() + direction.getyChange());
        if(nodeInfo.getX() < 0 || nodeInfo.getX() >= M || nodeInfo.getY() < 0 || nodeInfo.getY() >= N){
            return null;
        }
        if(map[nodeInfo.getX()][nodeInfo.getY()] == '#'){
            return null;
        }
        return nodeInfo;
    }
}
