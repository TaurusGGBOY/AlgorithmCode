public class Codec {

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		char[] ca = longUrl.toCharArray();
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < longUrl.length(); i++) {
			stringBuilder.append(String.valueOf((char) (ca[i] + 1)));
		}
		return stringBuilder.toString();
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		char[] ca = shortUrl.toCharArray();
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < shortUrl.length(); i++) {
			stringBuilder.append(String.valueOf((char) (ca[i] - 1)));
		}
		return stringBuilder.toString();
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));