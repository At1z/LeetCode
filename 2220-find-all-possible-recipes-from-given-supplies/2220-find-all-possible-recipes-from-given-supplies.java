class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> finalProducts = new ArrayList<>();
        int[] canBeDone = new int[recipes.length];
        Set<String> suppliesSet = new HashSet<>(Arrays.asList(supplies));
        Map<String, Integer> recipeIndexMap = new HashMap<>();

        for (int i = 0; i < recipes.length; i++) {
            recipeIndexMap.put(recipes[i], i);
        }

        for (int recipe = 0; recipe < recipes.length; recipe++) {
            if (canBeDone[recipe] == 0) {
                if (checkInRecipe(recipes[recipe], recipeIndexMap, suppliesSet, canBeDone, ingredients, new HashSet<>())) {
                    finalProducts.add(recipes[recipe]);
                }
            } else if (canBeDone[recipe] == 1) {
                finalProducts.add(recipes[recipe]);
            }
        }
        return finalProducts;
    }

    public boolean checkInRecipe(String ingredient, Map<String, Integer> recipeIndexMap, Set<String> suppliesSet, int[] canBeDone, List<List<String>> ingredients, Set<String> visiting) {
        if (suppliesSet.contains(ingredient)) {
            return true;
        }

        if (!recipeIndexMap.containsKey(ingredient)) {
            return false;
        }

        int recipeIndex = recipeIndexMap.get(ingredient);

        if (visiting.contains(ingredient)) {
            return false;
        }

        if (canBeDone[recipeIndex] == -1) {
            return false;
        } else if (canBeDone[recipeIndex] == 1) {
            return true;
        }

        visiting.add(ingredient);
        List<String> curIngredients = ingredients.get(recipeIndex);
        for (String ing : curIngredients) {
            if (!suppliesSet.contains(ing) && !checkInRecipe(ing, recipeIndexMap, suppliesSet, canBeDone, ingredients, visiting)) {
                canBeDone[recipeIndex] = -1;
                visiting.remove(ingredient);
                return false;
            }
        }

        canBeDone[recipeIndex] = 1;
        suppliesSet.add(ingredient);
        visiting.remove(ingredient);
        return true;
    }
}
