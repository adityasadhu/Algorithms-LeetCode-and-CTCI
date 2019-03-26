package Practice;

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
        List<List<Integer>> finalTransactions;

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

        int k = 0;
        String initialBlockHash = "0000000000000000000000000000000000000000";

        while (k < finalTransactions.size()) {
            List<String> blockTransactions = new ArrayList<>();
            for (int j = 0; j < blockSize && k < finalTransactions.size(); j++) {
                blockTransactions.add(finalTransactions.get(k).toString());
                k++;
            }

            int nonce = 0;

            String initialStringForBlockHash = buildStringForCalculatingBlockHash(initialBlockHash, nonce, blockTransactions);
            String blockHash = sha1(initialStringForBlockHash);

            do {
                nonce += 1;
                String s = buildStringForCalculatingBlockHash(initialBlockHash, nonce, blockTransactions);
                blockHash = sha1(s);
            } while (!blockHash.substring(0, 4).equals("0000"));

            Block b = new Block(initialBlockHash, Integer.toString(nonce), blockHash, blockTransactions.toString());
            initialBlockHash = blockHash;
            block.add(b);
        }

        return block.get(block.size() - 1).blockHash + ", " + block.get(block.size() - 1).prevBlockHash + ", " + block.get(block.size() - 1).nonce + ", " + block.get(block.size() - 1).blockTransactions;
    }

    private static String buildStringForCalculatingBlockHash(String initialBlockHash, int nonce, List<String> blockTransactions) {

        StringBuilder sb = new StringBuilder();
        sb.append(initialBlockHash);
        sb.append(", ");
        sb.append(nonce);
        sb.append(", ");
        sb.append(blockTransactions);

        return sb.toString();
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

        System.out.println(getLatestBlock(new int[]{3, 10, 10, 3}, new int[][]{{3, 2, 2}, {2, 3, 5}, {3, 2, 4}, {3, 0, 2}, {1, 2, 2}}, 2));

    }

    static public class Block {
        String prevBlockHash;
        String nonce;
        String blockHash;
        String blockTransactions;

        Block(String prevBlockHash, String nonce, String blockHash, String blockTransactions) {
            this.prevBlockHash = prevBlockHash;
            this.nonce = nonce;
            this.blockHash = blockHash;
            this.blockTransactions = blockTransactions;
        }
    }
}