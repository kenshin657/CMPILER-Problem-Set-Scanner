public class Token {
    enum TokenType {
        KEYWORD,
        FPR,
        GPR,
        ERROR,
    }

    public TokenType tokenType;
    public String lexeme;

    public Token(String word) {
        this.tokenType = identifyToken(word);
        this.lexeme = word;
    }



    public static TokenType identifyToken(String word){
        int state = 0;
        char[] ch = word.toCharArray();

        boolean R = false;
        boolean F = false;


        for (int i = 0; i < ch.length; i++) {
            switch (ch[i]) {
                case 'D':
                    if (state == 0)
                        state = 1;
                    else if (state == 2)
                        state = 4;
                    else if (state == 4)
                        state = 5;
                    else
                        state = 999; //DEAD STATE
                    break;
                case 'A':
                    if (state == 1)
                        state = 2;
                    else
                        state = 999;
                    break;
                case 'U':
                    if (state == 5)
                        state = 6;
                    else if (state == 7)
                        state = 8;
                    else if (state == 3)
                        state = 9;
                    else if (state == 11)
                        state = 12;
                    else if (state == 3)
                        state = 9;
                    else
                        state = 999;
                    break;
                case 'I':
                    if (state == 5)
                        state = 7;
                    else
                        state = 999;
                    break;
                case 'M':
                    if (state == 1)
                        state = 3;
                    else
                        state = 999;
                    break;
                case 'L':
                    if (state == 9)
                        state = 10;
                    else
                        state = 999;
                    break;
                case 'T':
                    if (state == 10)
                        state = 11;
                    else
                        state = 999;
                case  ',':
                    if (state == 0)
                        state = 0;
                    else if (state == 6)
                        state = 6;
                    else if (state == 8)
                        state = 8;
                    else if (state == 11)
                        state = 11;
                    else if (state == 12)
                        state = 12;
                    else if (state == 19)
                        state = 19;
                    else if (state == 18)
                        state = 18;
                    else if (state == 20)
                        state = 20;
                    else if (state == 17)
                        state = 17;
                    else if (state == 21)
                        state = 21;
                    else if (state == 22)
                        state = 22;
                    else
                        state = 999;
                    break;
                case 'R':
                    if (state == 0) {
                        state = 16;
                        R = true;
                    }
                    else
                        state = 999;
                    break;
                case 'F':
                    if (state == 0) {
                        state = 16;
                        F = true;
                    }
                    else if (state == 13) {
                        state = 16;
                        F = true;
                    }
                    else
                        state = 999;
                    break;
                case '$':
                    if (state == 0)
                        state = 13;
                    else
                        state = 999;
                    break;
                case '0':
                    if (state == 16)
                        state = 17;
                    else if (state == 18)
                        state = 20;
                    else if (state == 21)
                        state = 22;
                    else if (state == 13)
                        state = 17;
                    else
                        state = 999;
                    break;
                case '1':
                    if (state == 18)
                        state = 20;
                    else if (state == 13)
                        state = 21;
                    else if (state == 21)
                        state = 22;
                    else if (state == 16)
                        state = 21;
                    else
                        state = 999;
                    break;
                case '2':
                    if (state == 16)
                        state = 21;
                    else if (state == 21)
                        state = 22;
                    else if (state == 13)
                        state = 21;
                    else
                        state = 999;
                    break;
                case '3':
                    if (state == 16)
                        state = 18;
                    else if (state == 21)
                        state = 22;
                    else if (state == 13)
                        state = 18;
                    else
                        state = 999;
                    break;
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    if (state == 16)
                        state = 19;
                    else if (state == 21)
                        state = 22;
                    else if (state == 13)
                        state = 19;
                    else
                        state = 999;
                    break;
                default:
                    state = 999;
                    break;
            }
        }


        if (state == 6 || state == 8 || state == 11 || state == 12) {
            return TokenType.KEYWORD;
        }
        else if (state == 19 || state == 18 || state == 20 || state == 17 || state == 21 || state == 22) {
            if (R)
                return TokenType.GPR;
            else if (F)
                return TokenType.FPR;
            else
                return TokenType.GPR;
        }
        return TokenType.ERROR;
    }
}
