# Enterprise
Bu proje, Enterprise sitesinde çeşitli işlemleri otomatikleştirmek amacıyla geliştirilmiştir. Amacımız, kullanıcıların web sitesindeki rutin işlemleri daha hızlı ve verimli bir şekilde gerçekleştirmelerini sağlamaktır. Ayrıca, işlemler sırasında oluşabilecek hataları otomatik olarak tespit edip raporlayarak, kullanıcıların sorunları daha kolay bir şekilde çözmelerine yardımcı olur.

## Proje, aşağıdaki özellikleri sunar:

- Otomasyon: Belirlenen işlemleri otomatik olarak gerçekleştirir, böylece manuel müdahale ihtiyacını ortadan kaldırır.
- Hata Raporlama: İşlemler sırasında oluşabilecek hataları tespit eder ve detaylı raporlar sunar.
- Sonuç Görüntüleme: İşlemlerin sonuçlarını açık ve anlaşılır bir biçimde gösterir.


 ## İçindekiler
- [Kurulum](#kurulum)
- [Kullanım](#kullanım)
- [Özellikler](#özellikler)
- [Detaylar](#detaylar)
- [Katkıda Bulunma](#katkıda-bulunma)

## Kurulum
### 1. Ortam Değişkenleri (Environment Variables)

#### 1.1. Java JDK Kurulumu

1. **Java JDK İndirme ve Kurulum**:
   - Java JDK'nın en son sürümünü [Oracle JDK İndirme Sayfası](https://www.oracle.com/java/technologies/downloads/) üzerinden indirin.
   - İndirilen dosyayı çalıştırarak kurulum sihirbazını takip edin.
   - Kurulum tamamlandığında, JDK'nin kurulu olduğu dizini not edin (örneğin, `C:\Program Files\Java\jdk-11.0.x`).

![Ekran görüntüsü 2024-08-05 170740](https://github.com/user-attachments/assets/f6bb1d59-88b2-4076-8c4e-1d66a73b947e)
![Ekran görüntüsü 2024-08-05 170834](https://github.com/user-attachments/assets/44d9bce2-3a68-45b0-9749-2970ef851a4a)
![Ekran görüntüsü 2024-08-05 171257](https://github.com/user-attachments/assets/f909510d-3787-4830-acfb-9325e175cd13)
![Ekran görüntüsü 2024-08-05 171328](https://github.com/user-attachments/assets/6a0f5c57-e3f2-48f2-98a1-848c85882190)
![Ekran görüntüsü 2024-08-05 171417](https://github.com/user-attachments/assets/817ca1ab-db2d-4793-ac37-fef1d2f77c06)
![Ekran görüntüsü 2024-08-05 171432](https://github.com/user-attachments/assets/c0bfebeb-dbfb-468a-9861-e78ab263189d)


2. **JAVA_HOME Ortam Değişkenini Ayarlama**:
   - Bilgisayarınızdaki Denetim Masası'na gidin ve "Sistem ve Güvenlik" seçeneğini seçin.
   - "Sistem" üzerine tıklayın ve ardından "Gelişmiş sistem ayarları" seçeneğine tıklayın.
   - "Sistem Özellikleri" penceresinde, alt kısımda bulunan "Ortam Değişkenleri..." butonuna tıklayın.
   - "Sistem değişkenleri" bölümünde "Yeni" butonuna tıklayın.
   - Değişken adı olarak `JAVA_HOME` yazın.
   - Değişken değeri olarak JDK'nin kurulu olduğu dizini (örneğin, `C:\Program Files\Java\jdk-11.0.x`) yazın.
   - "Tamam" butonuna tıklayarak değişiklikleri kaydedin.

3. **PATH Ortam Değişkenini Güncelleme**:
   - Aynı Ortam Değişkenleri penceresinde, "Sistem değişkenleri" bölümünde `Path` değişkenini seçin ve "Düzenle..." butonuna tıklayın.
   - "Yeni" butonuna tıklayın ve JDK'nin `bin` dizinini (örneğin, `C:\Program Files\Java\jdk-11.0.x\bin`) ekleyin.
   - "Tamam" butonuna tıklayarak değişiklikleri kaydedin.

4. **Kurulumun Doğrulanması**:
   - Komut İstemi'ni (Command Prompt) açın.
   - `java -version` komutunu yazın ve Enter tuşuna basın. Java'nın kurulu olduğu sürüm bilgilerini görmelisiniz.
   - `javac -version` komutunu da kontrol ederek Java derleyicisinin kurulu olduğundan emin olun.

![Ekran görüntüsü 2024-08-05 172238](https://github.com/user-attachments/assets/5203cbab-66c2-4112-8cdc-0665efb0b78f)
![Ekran görüntüsü 2024-08-05 172414](https://github.com/user-attachments/assets/4f3afc9e-0319-485a-9a48-cbb5962d28ee)
![Ekran görüntüsü 2024-08-05 172514](https://github.com/user-attachments/assets/afc74b08-9104-4ac4-844c-db1e927cbf86)
![Ekran görüntüsü 2024-08-05 173222](https://github.com/user-attachments/assets/76ccce8c-af1a-424f-9fff-90ef7db1dd33)

### 2. IntelliJ IDEA Kurulumu

1. **IntelliJ IDEA İndirme ve Kurulum**:
   - IntelliJ IDEA'nın en son sürümünü [IntelliJ IDEA İndirme Sayfası](https://www.jetbrains.com/idea/download/) üzerinden indirin.
   - İndirilen dosyayı çalıştırarak kurulum sihirbazını takip edin.
   - Kurulum tamamlandığında IntelliJ IDEA'nın kurulu olduğu dizini not edin.

![Ekran görüntüsü 2024-08-05 155810](https://github.com/user-attachments/assets/5104db5b-9966-41f5-92f2-a804634437c9)
![Ekran görüntüsü 2024-08-05 155918](https://github.com/user-attachments/assets/82d9aec7-c290-4e27-80c2-a2f9b207ec44)
![Ekran görüntüsü 2024-08-05 160017](https://github.com/user-attachments/assets/1959298f-55a6-44b9-9ee3-657f575d01ad)
![Ekran görüntüsü 2024-08-05 160033](https://github.com/user-attachments/assets/4c67477e-b498-4a6d-b626-d0e4614abcc7)
![Ekran görüntüsü 2024-08-05 160052](https://github.com/user-attachments/assets/eeae0879-6fd6-4135-bca8-1c2cf527e2ad)



2. **IntelliJ IDEA ile Maven Projesini Açma**:
   - IntelliJ IDEA'yı açın.
   - "File" menüsünden "Open" seçeneğini tıklayın.
   - Projenizin bulunduğu dizini seçin ve "Open" butonuna tıklayın.
   - IntelliJ IDEA, Maven projenizi otomatik olarak algılayacak ve gerekli bağımlılıkları yükleyecektir.

3. **Maven Projesini Yapılandırma**:
   - Proje açıldığında, sağ üst köşede "Maven" sekmesini göreceksiniz. Bu sekmeyi kullanarak Maven komutlarını çalıştırabilirsiniz.
   - "pom.xml" dosyasını açarak proje bağımlılıklarını ve yapılandırmalarını inceleyin ve gerektiğinde güncelleyin.

### 3. XAMPP Kurulumu

1. **XAMPP İndirme ve Kurulum**:
   - XAMPP'nin en son sürümünü [XAMPP İndirme Sayfası](https://www.apachefriends.org/index.html) üzerinden indirin.
   - İndirilen dosyayı çalıştırarak kurulum sihirbazını takip edin.
   - Kurulum sırasında, Apache, MySQL, ve PHP gibi bileşenleri seçtiğinizden emin olun.
   - Kurulum tamamlandığında XAMPP'nin kurulu olduğu dizini not edin (örneğin, `C:\xampp`).

2. **XAMPP'yi Başlatma ve Konfigürasyon**:
   - XAMPP'yi açmak için XAMPP Kontrol Paneli'ni başlatın.
   - Apache ve MySQL hizmetlerini başlatın. Bu, web sunucusu ve veritabanı sunucusunun çalışmasını sağlar.
   - Tarayıcınızda `http://localhost` adresini açarak XAMPP'nin doğru şekilde kurulduğunu doğrulayabilirsiniz. XAMPP ana sayfasını görmelisiniz.

3. **Proje Dosyalarını Yükleme**:
   - Proje dosyalarını `htdocs` dizinine kopyalayın (örneğin, `C:\xampp\htdocs\projeniz`).
   - Web tarayıcısında `http://localhost/projeniz` adresini ziyaret ederek projenizi test edebilirsiniz.
### NOT:
## `DataBaseUtils` Klasörü

`DataBaseUtils` sınıfındaki veritabanı bağlantı bilgileri (`URL`, `USER`, `PASSWORD`) kendi ortamınıza göre güncellenmelidir. Bu bilgileri aşağıdaki gibi ayarlamanız gerekir:

1. **Veritabanı URL'si:**
   - `URL` değişkeni, veritabanı sunucunuzun adresini ve portunu belirtir. Genellikle bu, `jdbc:mysql://localhost:3306/enterprise` şeklindedir, burada `localhost` veritabanı sunucunuzun adresi, `3306` ise MySQL'in varsayılan portudur.

2. **Kullanıcı Adı ve Şifre:**
   - `USER` ve `PASSWORD` değişkenleri, veritabanına bağlanmak için kullanılan kullanıcı adı ve şifreyi temsil eder. Bu bilgileri veritabanı yöneticinizden alabilirsiniz. Örneğin:
     ```java
     private static final String USER = "kendi_kullanici_adiniz";
     private static final String PASSWORD = "kendi_sifreniz";
     ```
     
![Ekran görüntüsü 2024-08-05 160208](https://github.com/user-attachments/assets/758e4607-d435-470a-b759-8ce6fc45c503)
![Ekran görüntüsü 2024-08-05 160300](https://github.com/user-attachments/assets/f68b0d78-915a-4f58-9ab3-92c514a682e1)
![Ekran görüntüsü 2024-08-05 160410](https://github.com/user-attachments/assets/e6fc73a8-62e9-4ab6-84ec-ad313be3d87d)
![Ekran görüntüsü 2024-08-05 160456](https://github.com/user-attachments/assets/4641544c-4fd6-4a1d-949d-d9fa845048c2)
![Ekran görüntüsü 2024-08-05 160517](https://github.com/user-attachments/assets/c5dea59a-9626-457d-a96e-e8f3227e76ed)
![Ekran görüntüsü 2024-08-05 160537](https://github.com/user-attachments/assets/1e62aca4-ec41-4b4b-b30a-e30730a05270)
![Ekran görüntüsü 2024-08-05 160616](https://github.com/user-attachments/assets/82624509-64ab-41be-9eee-a886d4926195)
![Ekran görüntüsü 2024-08-05 160635](https://github.com/user-attachments/assets/3ed720c9-1aba-43e7-a122-182df602496c)
![Ekran görüntüsü 2024-08-05 160645](https://github.com/user-attachments/assets/91c0368c-8ccf-495f-baff-433709ac5139)
![Ekran görüntüsü 2024-08-05 160659](https://github.com/user-attachments/assets/af5868de-39fd-452b-a0f5-20953ecd679e)
![Ekran görüntüsü 2024-08-05 160750](https://github.com/user-attachments/assets/184de7a2-bb51-4717-bdfa-20dce1cc14ba)
![Ekran görüntüsü 2024-08-05 160905](https://github.com/user-attachments/assets/ceb351f8-8629-42a9-a063-d57abf60f4ec)

   

4. **Veritabanı ve Dataset Aktarımı**:

   - **Veritabanı oluşturmma**:
     - XAMPP kontrol panelinden "Admin" butonuna tıklayarak phpMyAdmin'i açın.
     - phpMyAdmin ana sayfasında, sol panelde "Databases" sekmesine tıklayın.
     - Yeni bir veritabanı oluşturmak için bir isim girin ve "Yeni" butonuna tıklayın.


   - **Veri Seti Aktarımı**:
     - Veritabanınızı oluşturduktan sonra, verileri eklemek için phpMyAdmin'de "İçe Aktar" sekmesini kullanabilirsiniz.
     - Veri setinizi içeren `.csv` veya `.sql` dosyasını seçin ve "içe aktar" butonuna tıklayarak verileri içe aktarın.(Verisetini kodun içinde bulabilirsiniz name_surname_corrected.csv)
     
![Ekran görüntüsü 2024-08-05 161015](https://github.com/user-attachments/assets/5092afc6-061c-4321-9025-d5ba0ea40049)
![Ekran görüntüsü 2024-08-05 161132](https://github.com/user-attachments/assets/f9d2f683-fb10-4d12-b4d7-429a1c5e848b)
![Ekran görüntüsü 2024-08-05 161225](https://github.com/user-attachments/assets/a999d6cb-0d71-4b56-86da-7f8658505e70)
![Ekran görüntüsü 2024-08-05 161352](https://github.com/user-attachments/assets/926b8d3e-402d-4c84-b211-3d2ecee36580)
![Ekran görüntüsü 2024-08-05 161550](https://github.com/user-attachments/assets/0b675872-e2ba-45a2-8b17-12e107f4e1e7)
![Ekran görüntüsü 2024-08-05 161626](https://github.com/user-attachments/assets/a037f4c4-d4bb-4398-8e71-a20a635ccd68)
![Ekran görüntüsü 2024-08-05 161732](https://github.com/user-attachments/assets/68b3c689-98b0-4032-a1c2-3d2f65e18b4c)
![Ekran görüntüsü 2024-08-05 161806](https://github.com/user-attachments/assets/ca8f34fb-8f4c-4942-a95d-9f465a726d31)
![Ekran görüntüsü 2024-08-05 161840](https://github.com/user-attachments/assets/3777aca4-7381-4a25-83c1-e365d77a96d9)
![Ekran görüntüsü 2024-08-05 161508](https://github.com/user-attachments/assets/719260f1-74f7-4543-8de2-9f97a911a4de)
![image](https://github.com/user-attachments/assets/190b784e-9c1f-48a7-a71c-aeb63278ff0f)

## Kullanım

## Kurulum Talimatları

### Gerekli Ön Koşullar

- Java Development Kit (JDK) 8 veya üzeri
- IntelliJ IDEA

### İndirme ve Kurulum

Depoyu Klonlama:
- GitHub reposunu klonlayın:
 ```shell
 git clone https://github.com/BartuPacall/EnterPrise.git
 ```
 ### IntelliJ IDEA'da Projeyi Açma:
 IntelliJ IDEA'yı açın ve "Open" seçeneğini kullanarak klonladığınız proje dizinine gidin.
 Proje Maven tarafından otomatik olarak tanınacaktır. IntelliJ IDEA, gerekli Maven bağımlılıklarını otomatik olarak indirip kuracaktır.

### TestNG Yapılandırması
testng.xml Dosyasını Kontrol Edin:
testng.xml dosyası projenizin kök dizininde bulunmalıdır. Bu dosya TestNG yapılandırmalarını ve listener'ları içerir. Dosya mevcut ve doğru yapılandırılmış olmalıdır.

### Maven Projesini Yeniden Yükleme:
Sol taraftaki Maven proje sekmesini açın (genellikle sağda, M simgesi ile).
Maven araç çubuğunda Refresh (Yenile) simgesine (genellikle iki ok) tıklayın. Bu, pom.xml dosyasındaki değişiklikleri algılar ve bağımlılıkları yeniden yükler.

![image](https://github.com/user-attachments/assets/f60ea6a9-0b6c-41b7-b23f-15883b9f3cfe)


### TestNG Listener'ları:
EmailableReporter ve diğer listener'lar projede kullanılır.
Test sonuçları test-output klasöründe bulunur.

![image](https://github.com/user-attachments/assets/3c499ea5-bd01-4ea7-a167-fa3c118c75c7)


### IntelliJ IDEA'da Testleri Çalıştırma:
testng.xml dosyasına sağ tıklayın "run" butonuna basın.

![Ekran Görüntüsü (665)](https://github.com/user-attachments/assets/dcbff152-2907-48b0-ae75-c40819630ddc)


### Testleri Tekrar Çalıştırma:
pom.xml dosyasındaki değişikliklerden sonra, IntelliJ IDEA'da Maven projelerini yenileyin.
TestNG yapılandırmasını ve listener'ları kontrol edin ve testlerinizi çalıştırın.

### Çıktıların Görüntülenmesi
Testler çalıştırıldığında, sonuçlar test-output klasöründe bulunur. Bu klasörde, emailable-report.html ve testng-failed.xml gibi dosyalar bulunur. Bu dosyalar test sonuçlarımızı detaylı bir şekilde gösterir.
 
![image](https://github.com/user-attachments/assets/708b242d-9135-4288-a9c4-2ebaf4fb902b)


## Özellikler

- **Otomatik Ekran Görüntüsü Alma:** Selenium WebDriver kullanarak otomatik olarak ekran görüntüsü alır ve belirlenen dizine kaydeder.
- **Rastgele Veri Alma:** MySQL veritabanından rastgele isim ve soyisim çeker. Bu, test verisi oluşturmak için kullanılabilir.
- **Dinamik Yapılandırma:** JSON dosyasından yapılandırma bilgilerini okur ve dinamik test konfigürasyonlarını destekler.
- **Raporlama:** Test sonuçlarını toplar ve kullanıcı dostu raporlar oluşturur.
- **TestNG Desteği:** TestNG çerçevesini kullanarak testleri yönetir ve çalıştırır.
- **Paralel Testler:** Testleri aynı anda birden fazla iş parçacığında çalıştırarak test sürelerini azaltır ve testlerinizi daha hızlı çalıştırır. TestNG'nin paralel test yürütme yeteneklerini kullanarak bu özelliği destekler.
- **Headless Mod:** Tarayıcıyı kullanıcı arayüzü olmadan arka planda çalıştırarak testleri daha hızlı ve daha verimli hale getirir. Özellikle sürekli entegrasyon (CI) ortamlarında faydalıdır.

## Detaylar

### Paralel Testler

Paralel testler, testlerinizi aynı anda birden fazla iş parçacığında çalıştırarak test sürelerini önemli ölçüde azaltabilir. TestNG kullanarak paralel testler yapılandırabilirsiniz:

- **TestNG Yapılandırması:** `testng.xml` dosyanızda paralel testler ayarlarını yapabilirsiniz.
- **Örnek TestNG Konfigürasyonu:**
  ```xml
  <suite name="ParallelSuite" parallel="tests" thread-count="5">
    <test name="Test1">
      <classes>
        <class name="com.example.tests.TestClass1"/>
      </classes>
    </test>
    <test name="Test2">
      <classes>
        <class name="com.example.tests.TestClass2"/>
      </classes>
    </test>
  </suite>
  ```
## Headless Mod
Headless mod, tarayıcının kullanıcı arayüzü olmadan çalışmasını sağlar, bu da testlerin daha hızlı çalışmasını ve CI/CD süreçlerinde daha verimli olmasını sağlar. Headless modda testler genellikle başsız (headless) tarayıcılar kullanılarak çalıştırılır:
Kodumuzda aktif etmek için true deaktif etmek için false yazarak headless modlu yada headless modu olmadan çalıştırabiliriz.
![image](https://github.com/user-attachments/assets/4e8f8077-a7c0-42f2-a784-0d54dd5d1445)

```java
public class HeadlessTest {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);

        driver.get("http://www.example.com");
        System.out.println("Title: " + driver.getTitle());

        driver.quit();
    }
}
```
## Katkıda Bulunma

Projeye katkıda bulunmak ister misiniz? İşte nasıl başlayabileceğinizle ilgili bazı basit adımlar:

1. **Projeyi Fork Edin:** 
   - Projeyi GitHub'dan fork ederek kendi kopyanızı oluşturun. Böylece değişikliklerinizi güvenli bir şekilde yapabilirsiniz.

2. **İssue Oluşturun:** 
   - Yeni bir özellik eklemek veya bir hatayı düzeltmek istiyorsanız, GitHub'da bir issue oluşturun ya da mevcut issue'lara göz atın.

3. **Geliştirin:** 
   - Kendi fork'ınızdaki projede geliştirmeler yapın. Kodunuzu yazarken dikkatli olun ve proje kurallarına uymaya çalışın.

4. **Pull Request Gönderin:** 
   - Değişikliklerinizi ana projeye dahil etmek için bir pull request (PR) oluşturun. Pull request'inizde neler yaptığınızı ve neden yaptığınızı açıklayan bir mesaj yazın.

5. **Kod Standartlarına Uyun:** 
   - Kodunuzu yazarken proje standartlarına uygun olmaya özen gösterin. Kodunuzun temiz ve anlaşılır olmasına dikkat edin.

6. **Testler Ekleyin:** 
   - Değişikliklerinizin çalıştığını kontrol etmek için testler ekleyin veya mevcut testleri güncelleyin.

7. **Dokümantasyonu Güncelleyin:** 
   - Yeni bir özellik eklediğinizde veya bir değişiklik yaptığınızda, `README.md` dosyasını ve diğer dokümanları güncellemeyi unutmayın.

8. **Geri Bildirim:** 
   - Pull request'lerinize gelen geri bildirimlere dikkat edin ve gerekirse değişiklik yapın. 

9. **Yardımcı Olun:** 
    - Projeye katkıda bulunmanın yanı sıra, topluluğa yardımcı olabilir ve projeyi geliştirmeye destek olabilirsiniz.

Katkılarınız için şimdiden teşekkürler!
