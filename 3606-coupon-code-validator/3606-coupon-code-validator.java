class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        List<String> order = List.of(
                "electronics",
                "grocery",
                "pharmacy",
                "restaurant"
        );

        Set<String> bLine = new HashSet<>(order);

        return IntStream.range(0, code.length)
                .filter(i ->
                        isActive[i] &&
                        code[i] != null &&
                        !code[i].isEmpty() &&
                        code[i].matches("[A-Za-z0-9_]+") &&
                        bLine.contains(businessLine[i])
                )
                .boxed()
                .sorted(
                        Comparator
                                .comparing((Integer i) -> order.indexOf(businessLine[i]))
                                .thenComparing(i -> code[i])
                )
                .map(i -> code[i])
                .collect(Collectors.toList());
    }
}
