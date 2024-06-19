Carla Backend Case - I chose Exercise B and I used shared/salary_datasets/salary_survey-3.csv dataset.

Exercise B: Database Design Exercise - Storing Compensation Data The goal of this exercise is to design a highly normalized database schema for storing compensation data

Create a schema for storing the compensation data provided in one of the available data sets. This schema should be in at least 3NF with tables for employee, role, and anything else that makes sense for the data given. Upload at least one dataset to the schema Stretch Goal: upload all 3 salary datasets to the database schema Validate that you can perform the following queries. You can export the results of these queries via CSV or attach screenshots of the the output Average compensation of roles where the role is some kind of engineer (hint: ILIKE) Average, min, and max compensation per city (if available in dataset) One interesting query of your choice (average compensation by gender perhaps???) Create a quick database schema diagram Many admin tools and clients will allow you to generate these from your schema. If not possible, just draw a super-simple diagram in MS Paint or similar tool 🎨

Öncelikle terminal üzerinden docker-compose klasörüne gidip, docker'ı ayağa kaldırıyoruz.

cd docker-compose docker-compose -f infra.yml up -d

Sonrasında, kullandığım dataset 'salary_survey-3.csv' dosyasından verileri tablolarıma kaydetmek için CompensationDataIntegrationService'in içerisindeki 'readCompensationDataFromCsv' metodunu DataBootstrap'te çalıştırıyoruz. CSV'deki verileri tablolarımıza yazmış oluyoruz.

Tabloları 3NF modeline uygun şekilde oluşturduk. Şemanın detaylarını aşağıda bulabilirsiniz. Ek olarak, sadece engineer'a özel ortalama maaş servisinin endpointi oluşturuldu. İsteğe göre '/get-engineer-avg-salary' GET isteği atılarak da dönen veri kontrol edilebilir.

Aşağıda mevcut sorgulara ait çıktı örnekleri de paylaşılmıştır.

<img width="646" alt="image" src="https://github.com/zaf012/carla-backend-case-01/assets/99869968/ada03308-938b-458b-8300-9fcb608e0dcd">

<img width="818" alt="image" src="https://github.com/zaf012/carla-backend-case-01/assets/99869968/0508078b-0b85-4c29-9961-f8d43f73f96c">

[__Average__min_and_mcompensation_per_city_2.csv](https://github.com/user-attachments/files/15906491/__Average__min_and_mcompensation_per_city_2.csv)


<img width="793" alt="image" src="https://github.com/zaf012/carla-backend-case-01/assets/99869968/4354915b-134b-41a6-ae8b-d678ecc1569e">

<img width="825" alt="image" src="https://github.com/zaf012/carla-backend-case-01/assets/99869968/13d0bd88-a94b-4549-87b7-680854f73862">


