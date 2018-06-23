import org.grails.plugins.codecs.HexCodec
import org.grails.plugins.codecs.SHA256BytesCodec

class Test {
    public static void main(String[] args) {
        println(HexCodec.encode(SHA256BytesCodec.encode("safsf")))
    }
}
