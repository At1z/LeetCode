class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> finalProducts = new ArrayList<>();
        int[] canBeDone = new int[recipes.length];
        Set<String> suppliesSet = new HashSet<>(Arrays.asList(supplies));
        
        for (int recipe = 0; recipe < recipes.length; recipe++) {
            if (canBeDone[recipe] == 0) {
                List<String> curIngredients = ingredients.get(recipe);
                for (String ingredient : curIngredients) {
                    if (!suppliesSet.contains(ingredient) && !checkInRecipe(ingredient, recipes, suppliesSet, canBeDone, ingredients, new HashSet<>())) {
                        canBeDone[recipe] = -1;
                        break;
                    }   
                }
                if (canBeDone[recipe] != -1) {
                    finalProducts.add(recipes[recipe]);
                    suppliesSet.add(recipes[recipe]);
                    canBeDone[recipe] = 1;
                }
            } else if (canBeDone[recipe] == 1) {
                finalProducts.add(recipes[recipe]);
                suppliesSet.add(recipes[recipe]);
            }
        }
        return finalProducts;
    }

    public boolean checkInRecipe(String ingredient, String[] recipes, Set<String> suppliesSet, int[] canBeDone, List<List<String>> ingredients, Set<Integer> visited){
        int recipeIndex = -1;
        for (int i = 0; i < recipes.length; i++) {
            if (recipes[i].equals(ingredient)) {
                recipeIndex = i;
                break;
            }
        }

        if (recipeIndex == -1 || canBeDone[recipeIndex] == -1 || visited.contains(recipeIndex)){
            return false;
        }

        if (canBeDone[recipeIndex] == 1) {
            return true;
        }

        visited.add(recipeIndex);
        List<String> curIngredients = ingredients.get(recipeIndex);
        for (String ing : curIngredients) {
            if (!suppliesSet.contains(ing) && !checkInRecipe(ing, recipes, suppliesSet, canBeDone, ingredients, visited)) {
                canBeDone[recipeIndex] = -1;
                visited.remove(recipeIndex);
                return false;
            }
        }
        
        canBeDone[recipeIndex] = 1;
        visited.remove(recipeIndex);
        return true;
    }
}
