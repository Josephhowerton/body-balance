package com.fitness.domain.model.nutrition

data class Ingredient(
    val foodId: String? = null,
    val food: String? = null,
    val foodCategory: String? = null,
    val image: String? = null,
    val measure: String? = null,
    val quantity: Double? = null,
    val detailed: String? = null,
    val weight: Double? = null,
    val uri: String? = "",
    val label: String? = null,
    val knownAs: String? = null,
    val category: String? = null,
    val categoryLabel: String? = null,
    val calories: Int? = null,
    val cautions: List<String>? = null,
    val dietLabels: List<String>? = null,
    val healthLabels: List<String>? = null,
    val totalWeight: Double? = 0.0,
    val measureLabel: String? = null,
    val qualifierLabel: String? = null,
    val qualifierUri: String? = null,
    val measureUri: String? = null,
    val measureWeight: Double? = null,
    val nutrients: Map<String, Nutrient>? = null
)