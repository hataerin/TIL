# Amazon S3 파일 서버



## Amazon S3란?

Amazon Simple Storage Service(Amazon S3)는 인터넷 스토리지 서비스입니다.

언제 어디서든지 데이터를 저장하고 검색하여 사용 가능합니다.

- **버킷 만들기** - 데이터를 저장하는 버킷을 만들고 해당 버킷의 이름을 지정합니다. 버킷은 데이터 스토리지를 위한 Amazon S3의 기본 컨테이너입니다.
- 데이터 저장 - 버킷에 데이터를 무한정으로 저장합니다. Amazon S3 버킷에 객체를 원하는 만큼 업로드할 수 있으며, 각 객체에 최대 5TB의 데이터를 포함할 수 있습니다. 각 객체는 고유한 개발자 할당 키를 사용하여 저장 및 검색합니다.
- 데이터 다운로드 - 데이터를 직접 다운로드하거나 다른 사람이 다운로드할 수 있도록 합니다. 언제든지 데이터를 직접 다운로드하거나 다른 사람이 다운로드하도록 허용할 수 있습니다.
- **권한** - 데이터를 Amazon S3 버킷으로 업로드 또는 다운로드하려는 사용자에게 액세스 권한을 부여하거나 해당 권한을 거부합니다. 3가지 유형의 사용자에게 업로드 및 다운로드 권한을 부여할 수 있습니다. 인증 메커니즘을 사용하면 데이터가 무단으로 액세스되지 않도록 보호하는 데 도움이 될 수 있습니다.
- **표준 인터페이스** - 모든 인터넷 개발 도구 키트에서 사용할 수 있도록 설계된 표준 기반 REST 및 SOAP 인터페이스를 사용합니다.

## Spring에서 S3 사용하기

Spring과 S3를 연동해서 파일 저장과 주소 반환 기능만 적용했습니다.

### S3 구축

aws 계정이 필요합니다. 여기서는 프리티어로 s3를 만들며 설명하겠습니다.

1. 계정 아이디를 누르고 [내 보안 자격 증명]을 클릭합니다. 그 후, 좌측 목차에서 [사용자] 클릭 후 [사용자 추가]를 합니다.

![image](https://user-images.githubusercontent.com/33201813/122178415-84fb3e00-cec1-11eb-9ba9-888c3f7ec351.png)

1. 사용자 세부 정보 설정을 합니다.

   [사용자 이름]을 입력 후, 우리는 프로그래밍으로 접근할 것이기 때문에 [프로그래밍 박식 엑세스]를 선택합니다.

   ![image](https://user-images.githubusercontent.com/33201813/122178747-d4da0500-cec1-11eb-9fa9-5836ef26e570.png)

2. 기존 정책 직접 연결에서 [AmazonS3FullAccess]를 선택하고 넘어갑니다.

![image](https://user-images.githubusercontent.com/33201813/122179208-4023d700-cec2-11eb-8ea7-26689cbbc0e3.png)

1. 계속 다음다음다음... 눌러서 생성합니다.

   그럼 엑세스키와 비밀키가 생성된 것을 확인할 수 있습니다.

![image](https://user-images.githubusercontent.com/33201813/122183820-9135ca00-cec6-11eb-84a9-e6c604bf688a.png)

1. s3에 접속 후, 버킷만들기를 클릭합니다.

![image](https://user-images.githubusercontent.com/33201813/122177425-942dbc00-cec0-11eb-931f-c2f417dc1c88.png)

1. 버킷이름과 리전을 선택합니다.

![image](https://user-images.githubusercontent.com/33201813/122180539-7b72d580-cec3-11eb-96ea-81c62632929d.png)

1. 엑세스 차단 설정을 해제합니다. 그리고 생성합니다.

![image](https://user-images.githubusercontent.com/33201813/122183982-bb878780-cec6-11eb-8da7-a334b78e49f4.png)

1. 생성된 버킷에 들어간 후, 권한에서 버킷 정책 편집을 클릭합니다.

![image](https://user-images.githubusercontent.com/33201813/122181767-9db92300-cec4-11eb-996b-c788645fdabe.png)

![image](https://user-images.githubusercontent.com/33201813/122181949-c6411d00-cec4-11eb-8d53-f0c0de99130e.png)

1. 버킷 정책 편집에서 [버킷 ARN]부분을 복사 후, [정책 생성기]를 클릭합니다.

![image](https://user-images.githubusercontent.com/33201813/122182088-e96bcc80-cec4-11eb-8f75-6094b2bafb6f.png)

1. 버킷 정책 생성을 아래와 같이 새줍니다. [ARN]은 이전 복사한 것을 넣어주고, 마지막에 /*를 붙입니다.

   [Actions]에서 GetObject를 선택합니다.

![image](https://user-images.githubusercontent.com/33201813/122182226-0dc7a900-cec5-11eb-8a6f-69c7da42127c.png)

1. 정상적으로 만들어졌고, Generate Policy를 눌러서 정책 코드를 복사합니다.

![image](https://user-images.githubusercontent.com/33201813/122184147-e5d94500-cec6-11eb-8c78-3ad7fb5412d8.png)

1. 다시 [버킷 정책 편집]으로 돌아와서 붙여넣고 저장합니다.

![image](https://user-images.githubusercontent.com/33201813/122182574-5b441600-cec5-11eb-989a-317fff09848a.png)

1. 그러면 [퍼블릭 엑세스 가능]이라는 창이 나오고, 테스트로 업로드한 사진을 링크따라 들어가서 확인이 가능해집니다.

![image](https://user-images.githubusercontent.com/33201813/122183260-05bc3900-cec6-11eb-975a-b96e549ddd02.png)

### Spring에서 S3 연동

#### 환경설정

- **gradle.build**

```
dependencies{
 implementation platform('com.amazonaws:aws-java-sdk-bom:1.11.934')
 implementation 'com.amazonaws:aws-java-sdk-s3'
 annotationProcessor "org.springframework.boot:spring-boot-configuration-processor"
}
```

- **application.xml**

```
cloud:
  aws:
    credentials:
      accessKey: 입력
      secretKey: 입력
    s3:
      bucket: thxstore
    region:
      static: ap-northeast-2
    stack:
      auto: false
```

aws에서 확인 후, accessKey, secretKey 입력

** 위 [accessKey, SecurityKey 생성] 파트에서 4번 참조

#### 연동할 클래스 생성 및 설정

- **ImageService.java**

  서비스에서 호출하여 사용하는 부분입니다.

```
@Service
@Transactional
@RequiredArgsConstructor
public class ImageService {
    private final AwsS3Service awsS3Service;
    // 자신의 버킷 주소로 입력하셔야합니다
    public static final String DOMAIN_NAME = "thxstore.s3.ap-northeast-2.amazonaws.com";

    public String createImage(MultipartFile image) throws IOException {
        String imgName = awsS3Service.uploadImage(image);
        // 반환할 주소값
        String imgPath = "https://" + DOMAIN_NAME + "/" + imgName;

        return imgPath;
    }
}
```

- **AwsS3Service.java**

  Amazon S3 서버에 실제로 저장되는 부분입니다. ImageService.java는 사용자 편의를 위해 만들어진 클래스 파일이며, AwsS3Service.java는 실제 서버 버킷에 형식에 맞춰 저장이 됩니다.

```
@Service
@RequiredArgsConstructor
public class AwsS3Service {
    private final AwsConfiguration awsConfiguration;
    private final AwsS3Property awsS3Property;
    private AmazonS3 amazonS3;

    @Transactional
    public String uploadImage(MultipartFile image) throws IOException {
        amazonS3 = awsConfiguration.setS3Client();
        UUID uuid = UUID.randomUUID();
        long time = System.currentTimeMillis();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss", Locale.KOREA);
        // 시간 + 파일이름으로 중복 X
        String imageName = uuid + "-" + formatter.format(time) + image.getOriginalFilename();


        File uploadFile = convert(image)
                .orElseThrow(() -> new IllegalArgumentException("MultipartFile -> File로 전환이 실패했습니다."));

        amazonS3.putObject(new PutObjectRequest(awsS3Property.getBucket(), imageName, uploadFile)
                .withCannedAcl(CannedAccessControlList.PublicRead));
        removeNewFile(uploadFile);
        return imageName;
    }

    private Optional<File> convert(MultipartFile file) throws IOException {
        File convertFile = new File(file.getOriginalFilename());
        if(convertFile.createNewFile()) {
            try (FileOutputStream fos = new FileOutputStream(convertFile)) {
                fos.write(file.getBytes());
            }
            return Optional.of(convertFile);
        }
        return Optional.empty();
    }

    private void removeNewFile(File targetFile) {
        targetFile.delete();
    }
}
```

- **awss3property.java**

  aws 권한 클래스(application.xml)

```
@ConstructorBinding
@ConfigurationProperties(prefix = "aws.s3")
@NoArgsConstructor
@Getter
public class AwsS3Property {
    @Value("${cloud.aws.credentials.accessKey}")
    private String accessKey;

    @Value("${cloud.aws.credentials.secretKey}")
    private String secretKey;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @Value("${cloud.aws.region.static}")
    private String region;
}
```

- **AwsConfiguration.java**

```
@Configuration
@EnableConfigurationProperties(value = {AwsS3Property.class})
@RequiredArgsConstructor
public class AwsConfiguration {
    private final AwsS3Property awsS3Property;
    @PostConstruct
    public AmazonS3 setS3Client() {
        AWSCredentials credentials = new BasicAWSCredentials(awsS3Property.getAccessKey(), awsS3Property.getSecretKey());

        return AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(awsS3Property.getRegion())
                .build();
    }
}
```

## 마치며..

위와 같은 S3 방법은 권한을 열었기 때문에 보안에 취약할 수 있습니다. 엑세스 차단 설정이라던가 엑세스키 비밀키 설정, 버킷 정책 편집을 더 강화하는 것도 좋은 방법입니다.

