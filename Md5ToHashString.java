public class Md5ToHashString {
  
  //Convert the byte array in readable hex string
  private static String bytesToHex(byte[] hash) {
    StringBuffer hexString = new StringBuffer();
    for (int i = 0; i < hash.length; i++) {
      String hex = Integer.toHexString(0xff & hash[i]);
      if(hex.length() == 1) hexString.append('0');
      hexString.append(hex);
    }
    return hexString.toString();
  }

  public static void main (String [] args) throws Exception {
    SecureRandom secureRandom = new SecureRandom();
    
    //Uses SHA-256 hashing algorithm
    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
    
    List<String> output = new ArrayList<>();
    for (int i = 0; i < 10 ; i++) {
      output.add(
        bytesToHex(messageDigest.digest(String.valueOf(secureRandom.nextLong()).getBytes(StandardCharsets.UTF_8)))
      );
    }
  }
}
