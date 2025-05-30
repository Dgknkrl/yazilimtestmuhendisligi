public class TestRunner {
    public static void main(String[] args) {
        System.out.println("API Test Otomasyonu Başlatılıyor...\n");

        // TestNG programatik olarak çalıştırma
        org.testng.TestNG testng = new org.testng.TestNG();
        testng.setTestClasses(new Class[]{ApiTest.class});
        testng.run();

        System.out.println("\nTüm testler tamamlandı!");
    }
}