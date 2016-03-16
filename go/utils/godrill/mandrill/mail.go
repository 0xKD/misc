package mandrill

type Mail struct {
    Event string `json:"event"`
    Ts int `json:"ts"`
    Msg struct {
        RawMsg string `json:"raw_msg"`
        Headers struct {
            Received []string `json:"Received"`
            XGoogleDkimSignature string `json:"X-Google-Dkim-Signature"`
            XGmMessageState string `json:"X-Gm-Message-State"`
            MimeVersion string `json:"Mime-Version"`
            XReceived string `json:"X-Received"`
            Date string `json:"Date"`
            MessageID string `json:"Message-Id"`
            Subject string `json:"Subject"`
            From string `json:"From"`
            To string `json:"To"`
            ContentType string `json:"Content-Type"`
        } `json:"headers"`
        Text string `json:"text"`
        TextFlowed bool `json:"text_flowed"`
        HTML string `json:"html"`
        FromEmail string `json:"from_email"`
        FromName string `json:"from_name"`
        To [][]*string `json:"to"`
        Subject string `json:"subject"`
        Spf struct {
            Result string `json:"result"`
            Detail string `json:"detail"`
        } `json:"spf"`
        SpamReport struct {
            Score float64 `json:"score"`
            MatchedRules []struct {
                Name string `json:"name"`
                Score float64 `json:"score"`
                Description string `json:"description"`
            } `json:"matched_rules"`
        } `json:"spam_report"`
        Dkim struct {
            Signed bool `json:"signed"`
            Valid bool `json:"valid"`
        } `json:"dkim"`
        Email string `json:"email"`
        Tags []string `json:"tags"`
        Sender *string `json:"sender"`
        Template *string `json:"template"`
    } `json:"msg"`
}
