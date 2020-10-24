public class Main {
    public static void main(String[] args) {
        String text = "Еъёчхф Вхзёюлх, адздёиу ф ждэщхб, црбх еёдюэчъщъгюъв южаижжзчх, ждчъёнъгжзчдв. Ъы зёюивй жёхчгюв бюнс ж ъы вдгивъгзхбсгрв аёхкдв. \n" +
                "Зъеъёс вгъ дмъчющгд, мзд гъюэцъьгджзс тздшд аёхкх фчбфъзжф жбъщжзчюъв гъждчъёнъгжзчх мъбдчъмъжадшд югщючющиивх. \n" +
                "Ф юэимюб чхни южздёюу ю чгыж юэвъгъгюф, здмгъъ дзёхэюч еджздфггиу юэвъгмючджзс мъбдчъмъжаюк едёдадч. \n" +
                "Ю зъв гъ въгъъ, еджбъщдчхбх гъищхмх. Ф еёюнъб а чрчдщи, мзд чюгдя чжъви вдя югзъббъаз, х чдэвдьгд, вды мёъэвъёгдъ жзёъвбъгюъ ад чжъви шхёвдгюмгдви. \n" +
                "Гхязю ёънъгюъ вгъ едвдшбх еёдшёхввх югзиюзючгдшд зюех, жеълюхбсгд ждэщхггхф щбф юэимъгюф деёъщъбъггрк жздёдг мъбдчъмъжадя щиню. \n" +
                "Въгф вдьгд гхэчхзс дзлдв Вхзёюлр, х ъы, цъэ еёъичъбюмъгюф, вхзъёсу.";

        int numberOfLettersInRussianAlphabet = 33;

        char[] alphabet = new char[numberOfLettersInRussianAlphabet];

        char letter = 'а';
        for (int i = 0; i < numberOfLettersInRussianAlphabet; i++) {
            if (i == 6) {
                alphabet[6] = 'ё';
                continue;
            }
            alphabet[i] = letter++;
        }

        int shift = 32;
        int newIndexForLetter;

        char[] chars = text.toCharArray();

        for (int k = 0; k <= shift; k++) {
            for (int i = 0; i < chars.length; i++) {
                if (Character.isAlphabetic(chars[i]) && Character.isLowerCase(chars[i])) {
                    for (int j = 0; j < alphabet.length; j++) {
                        if (chars[i] == alphabet[j]) {
                            if ((j + shift) > alphabet.length - 1) {
                                newIndexForLetter = (j + shift) - alphabet.length;
                                chars[i] = alphabet[newIndexForLetter];
                                break;
                            }
                            chars[i] = alphabet[j + shift];
                            break;
                        }
                    }
                }
                if (Character.isAlphabetic(chars[i]) && Character.isUpperCase(chars[i])) {
                    chars[i] = Character.toLowerCase(chars[i]);
                    for (int j = 0; j < alphabet.length; j++) {
                        if (chars[i] == alphabet[j]) {
                            if ((j + shift) > alphabet.length - 1) {
                                newIndexForLetter = (j + shift) - alphabet.length;
                                chars[i] = Character.toUpperCase(alphabet[newIndexForLetter]);
                                break;
                            }
                            chars[i] = Character.toUpperCase(alphabet[j + shift]);
                            break;
                        }
                    }
                }
            }
            System.out.println(new String(chars) + "\n");
        }
    }
}
