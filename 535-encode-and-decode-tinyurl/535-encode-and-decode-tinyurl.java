public class Codec {
    HashMap<String, String> code = new HashMap<>(), url = new HashMap<>();
    static final String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public String getCode() {
        char[] code = new char[6];
        for (int i = 0; i < 6; i++) code[i] = chars.charAt((int) Math.random() * 62);
        return "http://tinyurl.com/" + String.valueOf(code);
    }
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (url.containsKey(longUrl)) return url.get(longUrl);
        String newUrl = getCode();
        while (code.containsKey(newUrl)) newUrl = getCode();
        url.put(longUrl, newUrl);
        code.put(newUrl, longUrl);
        return newUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return code.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));