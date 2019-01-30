package practice;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class BlockChain {

    static public String sha1(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }


    static public String getLatestBlock(int[] startBalances, int[][] pendingTransactions, int blockSize) throws NoSuchAlgorithmException {


        List<List<Integer>> pendingTrns = new ArrayList<>();

        List<List<Integer>> finalTransactions = new ArrayList<>();

        for (int i = 0; i < pendingTransactions.length; i++) {
            pendingTrns.add(new ArrayList<>());
        }

        for (int i = 0; i < pendingTransactions.length; i++) {
            for (int j = 0; j < pendingTransactions[0].length; j++) {
                pendingTrns.get(i).add(pendingTransactions[i][j]);
            }
        }

        List<Block> block = new ArrayList<>();


        finalTransactions = removeAllInvalidTransactions(startBalances, pendingTrns);
        System.out.println("all valid transactions are" + finalTransactions);
        int k = 0;

        String initialBlockHash = "0000000000000000000000000000000000000000";
        while (k < finalTransactions.size()) {
            List<String> blockTransactions = new ArrayList<>();
            for (int j = 0; j < blockSize && k < finalTransactions.size(); j++) {
                blockTransactions.add(finalTransactions.get(k).toString());
                k++;
            }

            StringBuilder sb1 = new StringBuilder();
            sb1.append(initialBlockHash);
            sb1.append(", ");
            sb1.append("28427");
            sb1.append(", ");
            sb1.append(blockTransactions);

            String blockHash = sha1(sb1.toString());

            System.out.print(blockTransactions + "<--");
            Block b = new Block(initialBlockHash, "28427", blockHash, blockTransactions.toString());
            initialBlockHash = blockHash;
            block.add(b);
        }

        return block.get(block.size() - 1).blockHash;
    }

    private static List<List<Integer>> removeAllInvalidTransactions(int[] startBalances, List<List<Integer>> pendingTrns) {

        List<List<Integer>> finalTransactions = new ArrayList<>();
        for (List l : pendingTrns) {
            int balance = Integer.parseInt(l.get(2).toString());
            int startAddress = Integer.parseInt(l.get(0).toString());
            int endAddress = Integer.parseInt(l.get(1).toString());

            if (startBalances[startAddress] >= balance) {
                startBalances[startAddress] -= balance;
                startBalances[endAddress] += balance;
                finalTransactions.add(l);
            }
        }
        return finalTransactions;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {

        System.out.println(getLatestBlock(new int[]{5, 0, 0, 0}, new int[][]{{0, 1, 5}, {1, 2, 5}, {2, 3, 5}}, 1));

    }

    static public class Block {
        String prevBlockHash;
        String nonce;
        String blockHash;
        String blockTransactions;

        public Block(String prevBlockHash, String nonce, String blockHash, String blockTransactions) {
            this.prevBlockHash = prevBlockHash;
            this.nonce = nonce;
            this.blockHash = blockHash;
            this.blockTransactions = blockTransactions;
        }
    }
}
