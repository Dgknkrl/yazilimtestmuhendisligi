# API Test Projesi

Bu proje, **Rest-Assured** ve **TestNG** kullanarak JSONPlaceholder API’sine yönelik temel **GET** ve **POST** testlerini içerir.

## Özellikler

* **testGetRequest()**: Tek bir post kaydını (`/posts/1`) GET metodu ile çeker ve:

  * HTTP `200` kodunu doğrular
  * `userId` ve `id` değerlerini kontrol eder
  * Yanıt süresinin 1500 ms’den kısa olduğunu test eder
  * Konsola URL, status code, yanıt gövdesi ve süresi yazar

* **testPostRequest()**: Yeni bir post oluşturmak için `/posts` endpoint’ine POST isteği yapar ve:

  * HTTP `201` kodunu doğrular
  * Gönderilen JSON içeriğinin doğru şekilde döndüğünü kontrol eder (`title`, `userId`)
  * Yanıt süresinin 1500 ms’den kısa olduğunu test eder
  * Konsola URL, gönderilen veri, status code, yanıt gövdesi ve süresi yazar

* **testGetAllPosts()**: Tüm post listesini (`/posts`) GET metodu ile çeker ve:

  * HTTP `200` kodunu doğrular
  * Dönen listenin boş olmadığını kontrol eder
  * Yanıt süresinin 3000 ms’den kısa olduğunu test eder
  * Konsola URL, status code, toplam post sayısı, ilk post başlığı ve süresini yazar

## Kurulum ve Çalıştırma

1. Java 11 veya üzeri kurulu olmalıdır.
2. Maven ile bağımlılıkları indirin:

   ```bash
   mvn clean install
   ```
3. Testleri çalıştırmak için:

   ```bash
   mvn test
   ```

## Proje Yapısı

```
api-test/
├─ pom.xml             # Maven yapılandırması
├─ src/
│  ├─ main/            # (Opsiyonel) Uygulama kodları
│  └─ test/            # Test kodları
│     └─ java/
│        └─ ApiTest.java
└─ testng.xml          # TestNG suite dosyası
```

## Bağımlılıklar

* **Rest-Assured** 5.3.0
* **TestNG** 7.8.0
* **Jackson Databind** 2.15.2

---

Detaylı API testi veya performans ölçümü için bu yapı örnek teşkil eder ve kolayca genişletilebilir.
