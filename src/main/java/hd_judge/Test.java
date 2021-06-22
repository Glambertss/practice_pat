package hd_judge;


import common.Direction;
import common.NodeInfo;

import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;


public class Test {



    /**
     * 返回两个字符数组在对应位置上不同的字符的数量
     * @param original
     * @param target
     * @return
     */
    private static int cost(char[][] original, char[][] target){
        int count = 0;
        for(int i = 0; i < 3; i ++){
            for(int j = 0; j < 3; j ++){
                
                if(original[i][j] != target[i][j]){
                    count ++;
                }
            }
        }
        return count;

    }

    /**
     * 返回的事该数组的逆序数
     *
     * 注意：其中的X会转换成0
     * @param temp
     * @return
     */
    private static int cal(char[][] temp){
        char[] temp0 = new char[temp[0].length * temp.length];
        int count = 0;
        for(int i = 0; i < temp.length; i ++){
            for(int j = 0; j < temp[i].length; j ++){
                if(temp[i][j] == 'X' ){
                    temp0[count ++] = '0';
                }else {
                    temp0[count++] = temp[i][j];
                }

            }
        }
        final int length = temp0.length;

        int[] number = new int[length];
        number[length - 1] = 0;
        for(int i = length - 2; i >= 0; i --){
            for(int j = i; j < length - 1; j ++){
                if(temp0[i] > temp0[j + 1]){
                    number[i] = number[j + 1] + 1;
                    break;
                }else if(temp0[i] == temp0[j + 1]){
                    number[i] = number[j + 1];
                    break;
                }
            }
        }
        int sum = 0;
        for(int i = 0; i < number.length; i ++){
            sum += number[i];
        }
        return sum;

    }

    public static boolean isColser(char[][] input, NodeInfo before, NodeInfo after, int targetCal){
        int cal = cal(input);
        char[][] tempCharArray = new char[input.length][input[0].length];
        twoDArrayCopy(input, tempCharArray);

        int distance = Math.abs(cal - targetCal);
        char temp = tempCharArray[before.getX()][before.getY()];
        tempCharArray[before.getX()][before.getY()] = tempCharArray[after.getX()][after.getY()];
        tempCharArray[after.getX()][after.getY()] = temp;

        int cal1 = cal(tempCharArray);
        int distance2 = Math.abs(cal1 - targetCal);
        if(distance2 <= distance){
            return true;
        }else{
            return false;
        }

    }

    /**
     * 新的计算规则：如果
     *      如果和目标位置相同，则+2
     *      如果和目标位置的行相同，但是列不同，则+1
     *      如果都不同，则+0
     * @return
     */
    public static int cost2(char[][] current, char[][] target){



    }


    public static boolean twoDEqual(char[][] t1, char[][] t2){
        for(int i = 0; i < t1.length; i ++){
            for(int j = 0; j < t1[0].length; j ++){
                if(t1[i][j] != t2[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * 使用 System.arraycopy 方法
     *
     * @param sourceArr 源数组
     * @param destArr   目标数组
     */
    public static void twoDArrayCopy(char[][] sourceArr, char[][] destArr) {
        for (int i = 0; i < sourceArr.length; i++) {
            if (sourceArr[i].length >= 0) {
                System.arraycopy(sourceArr[i], 0, destArr[i], 0, sourceArr[i].length);
            }
        }
    }








    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConcurrentLinkedQueue<NodeInfo> nodeInfos = new ConcurrentLinkedQueue<>();
        int testCase = scanner.nextInt();

        for(int i = 0 ; i < testCase; i ++){
            char[][] input = new char[3][3];
            char[][] target = new char[3][3];

            scanner.nextLine();
            String temp0 = scanner.nextLine();
            char[] chars = temp0.toCharArray();
            for(int j = 0 ; j < chars.length; j ++){
                input[j / 3][j % 3] = chars[j];
                if(chars[j] == 'X'){
                    NodeInfo nodeInfo = new NodeInfo(j / 3, j % 3);
                    nodeInfos.add(nodeInfo);
                }
            }

            String temp1 = scanner.nextLine();
            char[] chars1 = temp1.toCharArray();
            for(int j = 0 ; j < chars1.length; j ++){
                target[j / 3][j % 3] = chars1[j];
            }
            final int targetNumber = cal(target);


            while(nodeInfos.size() > 0){
                NodeInfo poll = nodeInfos.poll();
                for (Direction direction : Direction.values()) {
                    NodeInfo nodeInfo = new NodeInfo(poll.getX() + direction.getxChange(), poll.getY() + direction.getyChange());
                    if(nodeInfo.getX() < 0 || nodeInfo.getX() >= 3 || nodeInfo.getY() < 0 || nodeInfo.getY() >= 3){
                        continue;
                    }else{
                        if(isColser(input, poll, nodeInfo, targetNumber)){
                            char temp = input[nodeInfo.getX()][nodeInfo.getY()];
                            input[nodeInfo.getX()][nodeInfo.getY()] = input[poll.getX()][poll.getY()];
                            input[poll.getX()][poll.getY()] = temp;
                            System.out.println(direction.getSignal());
                            if(!twoDEqual(input, target)){
                                nodeInfos.add(nodeInfo);
                            }
                            break;
                        }
                    }

                }


            }

        }

    }
}

