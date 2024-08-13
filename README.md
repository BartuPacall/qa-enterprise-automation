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

![Ekran görüntüsü 2024-08-05 170740](https://github.com/user-attachments/assets/1b29857a-79ec-4047-9f2a-f0dd58ec2476)
![Ekran görüntüsü 2024-08-05 170834](https://github.com/user-attachments/assets/2bed2042-ef61-4291-a696-052b96d93470)
![Ekran görüntüsü 2024-08-05 171257](https://github.com/user-attachments/assets/2611f068-7429-4557-be9c-de1ec4af6405)
![Ekran görüntüsü 2024-08-05 171328](https://github.com/user-attachments/assets/dfd3dbfd-6523-4c70-b37d-95f221c1cd93)
![Ekran görüntüsü 2024-08-05 171417](https://github.com/user-attachments/assets/4afce346-2731-4700-9400-f5054bb873ea)
![Ekran görüntüsü 2024-08-05 171432](https://github.com/user-attachments/assets/3f515adc-9877-4a81-a8e1-279bc0ead039)

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

![Ekran görüntüsü 2024-08-05 172238](https://github.com/user-attachments/assets/71984890-2161-4cc1-9ad0-a275c21b47be)
![Ekran görüntüsü 2024-08-05 172414](https://github.com/user-attachments/assets/e25d2d73-6bcd-407b-932d-4256eacddbc6)
![Ekran görüntüsü 2024-08-05 172514](https://github.com/user-attachments/assets/dda3f6ed-d0c5-414a-82e3-7484ba232e39)
![Ekran görüntüsü 2024-08-05 173222](https://github.com/user-attachments/assets/428cfcb4-7f04-4cab-9da8-ec971de3ee75)

### 2. IntelliJ IDEA Kurulumu

1. **IntelliJ IDEA İndirme ve Kurulum**:
   - IntelliJ IDEA'nın en son sürümünü [IntelliJ IDEA İndirme Sayfası](https://www.jetbrains.com/idea/download/) üzerinden indirin.
   - İndirilen dosyayı çalıştırarak kurulum sihirbazını takip edin.
   - Kurulum tamamlandığında IntelliJ IDEA'nın kurulu olduğu dizini not edin.

![Ekran görüntüsü 2024-08-05 155810](https://github.com/user-attachments/assets/45865f9e-a52a-4917-bb3d-298a3ea71b8f)
![Ekran görüntüsü 2024-08-05 155918](https://github.com/user-attachments/assets/d127a265-53b0-4137-8522-384b17a3d4c1)
![Ekran görüntüsü 2024-08-05 160017](https://github.com/user-attachments/assets/ee62d43b-7420-41fb-b15c-862c3b02d180)
![Ekran görüntüsü 2024-08-05 160033](https://github.com/user-attachments/assets/215e3771-f83e-4adf-bbb2-a3726bbadfd0)
![Ekran görüntüsü 2024-08-05 160052](https://github.com/user-attachments/assets/33ff4c54-9b0d-48bd-8832-46b6f5beebfd)



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
![Ekran görüntüsü 2024-08-05 160208](https://github.com/user-attachments/assets/29ebc8ce-74e8-46d4-b9fe-c59d5527d0eb)
![Ekran görüntüsü 2024-08-05 160300](https://github.com/user-attachments/assets/41415dc3-5dc5-4072-98fa-8e416e282a1c)
![Ekran görüntüsü 2024-08-05 160410](https://github.com/user-attachments/assets/9eff8d49-d6e7-4567-b379-f36c902634a2)
![Ekran görüntüsü 2024-08-05 160456](https://github.com/user-attachments/assets/7d21c102-4d26-4ce9-9f6d-1f9e0996d5ed)
![Ekran görüntüsü 2024-08-05 160517](https://github.com/user-attachments/assets/f18eeada-0f75-47d2-bc32-d724c9f78e47)
![Ekran görüntüsü 2024-08-05 160537](https://github.com/user-attachments/assets/2a1b3740-9b68-4091-b9d7-23198cdb42d0)
![Ekran görüntüsü 2024-08-05 160616](https://github.com/user-attachments/assets/660528ca-f8ea-453e-bca5-a1b0f58bfd4b)
![Ekran görüntüsü 2024-08-05 160635](https://github.com/user-attachments/assets/6f719e6c-bf21-45d2-a391-468426fe3a7d)
![Ekran görüntüsü 2024-08-05 160645](https://github.com/user-attachments/assets/d4a4afca-9120-4d4b-9a4b-59fd3f4dbf56)
![Ekran görüntüsü 2024-08-05 160659](https://github.com/user-attachments/assets/bb68b4d9-e08d-4183-bc41-3804e52620b0)
![Ekran görüntüsü 2024-08-05 160750](https://github.com/user-attachments/assets/df8841ed-e210-4385-ad4c-678b99db9a8a)
![Ekran görüntüsü 2024-08-05 160905](https://github.com/user-attachments/assets/3bb0f47c-6b1f-4f43-90ca-3db4ad85611b)

4. **Veritabanı ve Dataset Aktarımı**:

   - **Veritabanı oluşturmma**:
     - XAMPP kontrol panelinden "Admin" butonuna tıklayarak phpMyAdmin'i açın.
     - phpMyAdmin ana sayfasında, sol panelde "Databases" sekmesine tıklayın.
     - Yeni bir veritabanı oluşturmak için bir isim girin ve "Yeni" butonuna tıklayın.


   - **Veri Seti Aktarımı**:
     - Veritabanınızı oluşturduktan sonra, verileri eklemek için phpMyAdmin'de "İçe Aktar" sekmesini kullanabilirsiniz.
     - Veri setinizi içeren `.csv` veya `.sql` dosyasını seçin ve "içe aktar" butonuna tıklayarak verileri içe aktarın.(Verisetini kodun içinde bulabilirsiniz name_surname_corrected.csv)
     
![Ekran görüntüsü 2024-08-05 161015](https://github.com/user-attachments/assets/f0b4ab35-b715-47b3-800f-67c7f67e595f)
![Ekran görüntüsü 2024-08-05 161132](https://github.com/user-attachments/assets/b2e2fc51-6223-4db2-97b6-5cdc6c5c1d3b)
![Ekran görüntüsü 2024-08-05 161225](https://github.com/user-attachments/assets/77de9cf3-fe36-4f52-a84e-809d535d6a5b)
![Ekran görüntüsü 2024-08-05 161352](https://github.com/user-attachments/assets/01f0d242-b4f8-4a27-8c84-beaa547acc39)
![Ekran görüntüsü 2024-08-05 161550](https://github.com/user-attachments/assets/71fecc3b-de5b-46c0-8066-d07bd4a84c03)
![Ekran görüntüsü 2024-08-05 161626](https://github.com/user-attachments/assets/d2153ccf-3463-4de5-8dcb-8bd907f8a4b0)
![Ekran görüntüsü 2024-08-05 161732](https://github.com/user-attachments/assets/1c5098eb-88c9-4f83-a26d-3e54d1419d3d)
![Ekran görüntüsü 2024-08-05 161806](https://github.com/user-attachments/assets/47e7f813-64f8-4bdf-8396-19cf3d33f773)
![Ekran görüntüsü 2024-08-05 161840](https://github.com/user-attachments/assets/f46c780d-6884-42b1-b2f1-dba449482bab)
![Ekran görüntüsü 2024-08-05 161508](https://github.com/user-attachments/assets/1a9ad069-a33c-4edd-9980-009fee011f6c)
![Ekran görüntüsü 2024-08-06 154152](https://github.com/user-attachments/assets/2ea5fc53-c4e2-48ce-bd52-7ef4a0e0cf00)


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

![Ekran görüntüsü 2024-08-06 154353](https://github.com/user-attachments/assets/b726bd0a-e8ee-496e-9af5-bb3550a3f20c)


### TestNG Listener'ları:
EmailableReporter ve diğer listener'lar projede kullanılır.
Test sonuçları test-output klasöründe bulunur.

![Ekran görüntüsü 2024-08-06 154501](https://github.com/user-attachments/assets/f4dbc617-7103-44d8-9148-31b88e4918a1)


### IntelliJ IDEA'da Testleri Çalıştırma:
testng.xml dosyasına sağ tıklayın "run" butonuna basın.

![Ekran Görüntüsü (665)](https://github.com/user-attachments/assets/dfcf7ebf-a10e-4dc5-bb09-8da6008cbf38)


### Testleri Tekrar Çalıştırma:
pom.xml dosyasındaki değişikliklerden sonra, IntelliJ IDEA'da Maven projelerini yenileyin.
TestNG yapılandırmasını ve listener'ları kontrol edin ve testlerinizi çalıştırın.

### Çıktıların Görüntülenmesi
Testler çalıştırıldığında, sonuçlar test-output klasöründe bulunur. Bu klasörde, emailable-report.html ve testng-failed.xml gibi dosyalar bulunur. Bu dosyalar test sonuçlarımızı detaylı bir şekilde gösterir.
 
![Ekran görüntüsü 2024-08-06 154844](https://github.com/user-attachments/assets/f03c28ca-3921-4946-8eea-c7699e872a2f)


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
![image](https://github.com/user-attachments/assets/7580158c-33af-42cb-914b-b2b8a86ce494)

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

# Jenkins
Jenkins, yazılım geliştirme süreçlerini otomatikleştirmek için kullanılan, açık kaynaklı bir sürekli entegrasyon (CI) ve sürekli teslim (CD) aracıdır. Geliştiricilerin kod değişikliklerini sürekli olarak test etmesini, derlemesini, ve dağıtmasını sağlar. Jenkins, çok sayıda eklenti desteğiyle çeşitli araçlarla entegre olabilir ve yazılım projelerinin otomatik olarak inşa edilmesine, test edilmesine ve dağıtılmasına olanak tanır.

## Kurulum :
Chrome'u açın ve arama kısmına jenkins Download yazınız.
![Ekran görüntüsü 2024-08-13 173422](https://github.com/user-attachments/assets/a094f17e-3c2c-4564-8b72-ad950d42f262)

1. **Jenkins İndirme:**
- İlgili siteye geldikten sonra hemen aşağıda işletim sistemlerinden size uygun olanı indiriniz ve kurunuz.<br><br>
-![Ekran görüntüsü 2024-08-13 173443](https://github.com/user-attachments/assets/79af58b9-36e3-4857-925d-b48371909504)
-![image](https://github.com/user-attachments/assets/8c2b75ce-1b42-40a9-a78e-3f7a37c3e36a)

2. **Kurulum Adımları:**
- Daha sonra tarayıcınızdan http://localhost:8080/ ‘e gidiniz.
- Daha sonrasında karşınıza gelen ekrandaki kırmızı yazıyla belirtilen dosyayı txt ile açın ve içindeki şifreyi kopyalayıp “Administrator password” kısmına yapıştırın.<br><br>
-![Ekran görüntüsü 2024-08-13 141545](https://github.com/user-attachments/assets/2e2093bc-7aea-42a9-a015-4c7e3ab5759c)
-![Ekran görüntüsü 2024-08-13 141126](https://github.com/user-attachments/assets/5cdf8190-13ca-4572-95e7-4745cb58a05a)
- Eğer sadece default pluginleri indirmek isterseniz “Install suggested plugins” butonuna basın ve devam edin. Fakat başka pluginler’de indirmek istiyorsanız “Select plugins to install” butonuna basın ve devam edin. 
- İndirme işlemleri sona erince sizden bir user yaratmanız istenecek.<br><br>
-![Ekran görüntüsü 2024-08-13 141608](https://github.com/user-attachments/assets/355fb15d-d16f-4513-9752-40da51efa2e9)
-![Ekran görüntüsü 2024-08-13 141629](https://github.com/user-attachments/assets/12d08d9a-ec32-496e-a257-7fd42d56c2c9)

3. **Jenkins Arayüzü:**
- User oluşturduktan sonra artık Jenkins arayüzündesiniz. Proje oluşturmadan önce şu eklentileri lütfen kurunuz(git, github, maven, testngresults) bunlar şuanki projemiz için yeterli olacaktır ekstradan eklemek istediklerinizi eklentiler kısmından aratarak bulabilirsiniz.
- Jenkinsi yönet -> Araçlar  kısmında kullanıcağınız maven ve git eklentilerini eklemeyi unutmayınız.<br><br>
-![Ekran görüntüsü 2024-08-13 141653](https://github.com/user-attachments/assets/3d96fb36-a83f-48ec-84a1-7b815cfee4d8)
-![Ekran görüntüsü 2024-08-13 141724](https://github.com/user-attachments/assets/c02c92d3-cb7d-4e9d-925e-c42f917e602a)
-![Ekran görüntüsü 2024-08-13 141740](https://github.com/user-attachments/assets/d96d9b19-40ac-46c8-a2ca-d2cd3effcee1)
-![image](https://github.com/user-attachments/assets/a1d40cc7-3ca8-458f-80a9-f3a81453f4e2)

4. **Yeni Proje Oluşturma:**
- Proje oluşturmak için yeni ögeye tıklayınız ve istediğiniz proje stilinizi seçiniz burda basit ve karmaşık olmayan projeler için freestyle project öerilir daha karmaşık projeler için pipeline ve maven tarzı projeleri seçebilirsiniz. Şimdilik biz free style project'i seçiyoruz.<br><br>
-![Ekran görüntüsü 2024-08-13 151418](https://github.com/user-attachments/assets/94a4aaac-7c79-47de-9fbd-e5ef82e5eb2a)
- Açıklama kısmına projenizi özetleyen kısa bir açıklama yazabilirsiniz. Bu projeyi parametrik hale getire basarak parametlerinizi ekleyebilirsiniz bu kısımda projeme headless test classes ve parallel suite için bazı parametreler seçtim.<br><br>
![Ekran görüntüsü 2024-08-13 151730](https://github.com/user-attachments/assets/fdfa2a24-724a-483a-94d3-2858dd8b0b5a)
- Örnek olarak headless mode:<br><br>
-![Ekran görüntüsü 2024-08-13 152057](https://github.com/user-attachments/assets/eb543745-5553-47f7-8453-ddbddb27b8ea)

5. **GitHub Entegrasyonu:**
#### Projemizi githuba yüklediğimiz için githubdan almak istiyoruz bunuda github repomuzun linkini yazarak yapıyoruz.<br><br>
-![Ekran görüntüsü 2024-08-13 175742](https://github.com/user-attachments/assets/0fbc950e-88e9-4c54-be16-f85bc2567caf)

6. **Git Entegrasyonu:**
- Kaynak yönetim kısmına geliyoruz ordan git'i seçiyoruz ve ilgili yere github repomuzun linkini yazıyoruz. Projemiz hangi branchteyse o branchin adını yazıyoruz.<br><br>
-![Ekran görüntüsü 2024-08-13 152339](https://github.com/user-attachments/assets/3371b2a9-8523-4f41-9991-077be03035d1)
-![Ekran görüntüsü 2024-08-13 152157](https://github.com/user-attachments/assets/fab7385b-29e1-4f59-87ef-0bf39944bb64)
-![Ekran görüntüsü 2024-08-13 152303](https://github.com/user-attachments/assets/7be20eb3-89b3-4b15-a621-e52f0a03a299)

7. **Maven Yapılandırması:**
- Yapılandırma adımlarına gelip En üst seviye maven hedeflerini çalıştıra basıyoruz ve mavenı seçiyoruz kutumuzada gerekli işlemleri yapması için kodumuzu yazıyoruz.<br><br>
-![Ekran görüntüsü 2024-08-13 153003](https://github.com/user-attachments/assets/f5e0ff90-43b8-4fef-b936-7241f19dff8f)
-![Ekran görüntüsü 2024-08-13 180028](https://github.com/user-attachments/assets/f0257538-cd31-4aea-93f5-8c3c1e527800)

7. **Test Sonuç Entegrasyonu:**
- Sonuçlarımızı görüntülemek için bir yol seçmemiz gerekiyor biz testng üstünden öğrenmek istediğimiz için bu seçeneği seçiyoruz kutu kısmına yolu default olarak bırakıyoruz ve onaylıyoruz. (Not: Eğer bu seçenek yoksa plugins kısmına gidip o kısımdan testng results pluginini indiriniz!)<br><br>
-![Ekran görüntüsü 2024-08-13 161636](https://github.com/user-attachments/assets/67bbd126-3516-4dc4-a66d-989d5236d3eb)
-![Ekran görüntüsü 2024-08-13 161701](https://github.com/user-attachments/assets/f6865ebb-6386-48b7-adc7-6a13b8e33571)

8. **Parametre Seçimi:**
- Bu kısımda parametrelere tıklıyoruz, istediğimiz parametreleri seçiyoruz ve kodumuzu prametreler ile çalıştırıyoruz.<br><br>
-![Ekran görüntüsü 2024-08-13 161751](https://github.com/user-attachments/assets/cf7d7ed3-1cd3-4940-b8be-229cdc94db5b)
-![Ekran görüntüsü 2024-08-13 161811](https://github.com/user-attachments/assets/fac46a44-5f2b-405f-be62-0a6d30134837)
-![Ekran görüntüsü 2024-08-13 162956](https://github.com/user-attachments/assets/248f1c8b-caaa-4e58-b635-2a06d22dbc6b)

9. **Test Sonuçlarını Görüntüleme:**
- En son kısımda kodumuzun test sonuçlarını görüyoruz bu kısımda detaylandırmak için iç kısmında bize daha detaylı hangi test ne kadar sürede tamamlandı kaçı doğru kaçı yanlış olduğunu daha detaylı olarak görebiliyoruz.<br><br>
-![Ekran görüntüsü 2024-08-13 162956](https://github.com/user-attachments/assets/5c4b44a8-f85a-4ea7-9f3f-61dcc2a84e84)
-![Ekran görüntüsü 2024-08-13 163003](https://github.com/user-attachments/assets/c7ac4f26-8e23-436f-8631-d5841d8ea7ac)
-![Ekran görüntüsü 2024-08-13 163026](https://github.com/user-attachments/assets/65efc97b-7da8-4593-86ea-1d405baebf3f)


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
