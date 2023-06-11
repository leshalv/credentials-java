import com.aliyun.credentials.OIDCRoleArnCredential;
import com.aliyun.credentials.models.Credential;
import com.aliyun.credentials.provider.OIDCRoleArnCredentialProvider;
import com.aliyun.credentials.utils.AuthConstant;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class OIDCRoleArnCredentialTest {

    @Test
    public void OIDCRoleArnCredentialTest() {
        OIDCRoleArnCredentialProvider provider = Mockito.mock(OIDCRoleArnCredentialProvider.class);
        Credential credential = Credential.builder()
                .accessKeyId("id")
                .accessKeySecret("secret")
                .securityToken("token")
                .type(AuthConstant.OIDC_ROLE_ARN)
                .expiration(64090527132000L)
                .build();
        Mockito.when(provider.getCredentials()).thenReturn(credential);

        OIDCRoleArnCredential newCredential = new OIDCRoleArnCredential("idTest", "secretTest",
                "tokenTest", 0L, provider);
        Assert.assertEquals("id", newCredential.getAccessKeyId());
        Assert.assertEquals("secret", newCredential.getAccessKeySecret());
        Assert.assertEquals(64090527132000L, newCredential.getExpiration());
        Assert.assertEquals("token", newCredential.getSecurityToken());
        Assert.assertEquals(AuthConstant.OIDC_ROLE_ARN, newCredential.getType());
    }

}
