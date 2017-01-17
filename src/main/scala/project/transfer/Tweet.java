package project.transfer;

import java.util.Date;

public class Tweet
{
    private Date createdAt;
    private String text;

    public Tweet()
    {
    }

    public Tweet(Date createdAt, String text)
    {
        this.createdAt = createdAt;
        this.text = text;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }
}
