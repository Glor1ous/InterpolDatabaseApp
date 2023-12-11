package org.example;

class Criminal {
    private String lastName;
    private String firstName;
    private String nickname;
    private int height;
    private String hairColor;
    private String distinctiveFeatures;
    private String citizenship;
    private String birthInfo;
    private String criminalProfession;
    private String lastCrime;

    public Criminal(String lastName, String firstName, String nickname, int height, String hairColor,
                    String distinctiveFeatures, String citizenship, String birthInfo,
                    String criminalProfession, String lastCrime) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.nickname = nickname;
        this.height = height;
        this.hairColor = hairColor;
        this.distinctiveFeatures = distinctiveFeatures;
        this.citizenship = citizenship;
        this.birthInfo = birthInfo;
        this.criminalProfession = criminalProfession;
        this.lastCrime = lastCrime;
    }

    public boolean matchesSearchCriteria(int searchOption, String searchValue) {
        switch (searchOption) {
            case 1:
                return lastName.contains(searchValue);
            case 2:
                return firstName.contains(searchValue);
            case 3:
                return nickname.contains(searchValue);
            case 4:
                return citizenship.contains(searchValue);
            case 5:
                return criminalProfession.contains(searchValue);
            default:
                return false;
        }
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Фамилия: " + lastName +
                "\nИмя: " + firstName +
                "\nКличка: " + nickname +
                "\nРост: " + height +
                "\nЦвет волос: " + hairColor +
                "\nОсобые приметы: " + distinctiveFeatures +
                "\nГражданство: " + citizenship +
                "\nМесто и дата рождения: " + birthInfo +
                "\nПреступная профессия: " + criminalProfession +
                "\nПоследнее дело: " + lastCrime + "\n";
    }
}