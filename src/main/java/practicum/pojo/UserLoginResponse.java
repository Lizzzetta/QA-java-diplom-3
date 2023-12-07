package practicum.pojo;

public class UserLoginResponse
{
    private Boolean success;
    private String accessToken;
    private String refreshToken;
    private Object user;

    public UserLoginResponse(Boolean success, String accessToken, String refreshToken, Object user)
    {
        this.success = success;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.user = user;
    }

    public UserLoginResponse()
    {
    }

    public Boolean getSuccess()
    {
        return success;
    }

    public void setSuccess(Boolean success)
    {
        this.success = success;
    }

    public String getAccessToken()
    {
        return accessToken;
    }

    public void setAccessToken(String accessToken)
    {
        this.accessToken = accessToken;
    }

    public String getRefreshToken()
    {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken)
    {
        this.refreshToken = refreshToken;
    }

    public Object getUser()
    {
        return user;
    }

    public void setUser(Object user)
    {
        this.user = user;
    }
}
