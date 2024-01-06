package enums

import com.fitness.resources.R
enum class ENutrient(val ntrCodeResId: Int, val nameResId: Int, val unit: Units) {
    ADDED_SUGAR(R.string.ntr_added_sugar_code, R.string.ntr_added_sugar, MassUnit.GRAM),
    CALCIUM(R.string.ntr_calcium_code, R.string.ntr_calcium, MassUnit.MILLIGRAM),
    NET_CARBOHYDRATE(R.string.ntr_net_carbohydrate_code, R.string.ntr_net_carbohydrate, MassUnit.GRAM),
    CARBOHYDRATE(R.string.ntr_carbohydrate_code, R.string.ntr_carbohydrate, MassUnit.GRAM),
    CHOLESTEROL(R.string.ntr_cholesterol_code, R.string.ntr_cholesterol, MassUnit.MILLIGRAM),
    ENERGY(R.string.ntr_energy_code, R.string.ntr_energy, MassUnit.KILOGRAM), // Adjust as needed for ENERGY unit
    FATTY_ACIDS_MONO(R.string.ntr_fatty_acids_mono_code, R.string.ntr_fatty_acids_mono, MassUnit.GRAM),
    FATTY_ACIDS_POLY(R.string.ntr_fatty_acids_poly_code, R.string.ntr_fatty_acids_poly, MassUnit.GRAM),
    FATTY_ACIDS_SAT(R.string.ntr_fatty_acids_sat_code, R.string.ntr_fatty_acids_sat, MassUnit.GRAM),
    TRANS_FAT(R.string.ntr_trans_fat_code, R.string.ntr_trans_fat, MassUnit.GRAM),
    DIETARY_FIBER(R.string.ntr_fiber_code, R.string.ntr_fiber, MassUnit.GRAM),
    FOLATE_DFE(R.string.ntr_folate_dfe_code, R.string.ntr_folate_dfe, MassUnit.MICROGRAM),
    FOLATE_FOOD(R.string.ntr_folate_food_code, R.string.ntr_folate_food, MassUnit.MICROGRAM),
    FOLIC_ACID(R.string.ntr_folic_acid_code, R.string.ntr_folic_acid, MassUnit.MICROGRAM),
    IRON(R.string.ntr_iron_code, R.string.ntr_iron, MassUnit.MILLIGRAM),
    MAGNESIUM(R.string.ntr_magnesium_code, R.string.ntr_magnesium, MassUnit.MILLIGRAM),
    NIACIN(R.string.ntr_niacin_code, R.string.ntr_niacin, MassUnit.MILLIGRAM),
    PHOSPHORUS(R.string.ntr_phosphorus_code, R.string.ntr_phosphorus, MassUnit.MILLIGRAM),
    POTASSIUM(R.string.ntr_potassium_code, R.string.ntr_potassium, MassUnit.MILLIGRAM),
    PROTEIN(R.string.ntr_protein_code, R.string.ntr_protein, MassUnit.GRAM),
    RIBOFLAVIN(R.string.ntr_riboflavin_code, R.string.ntr_riboflavin, MassUnit.MILLIGRAM),
    SODIUM(R.string.ntr_sodium_code, R.string.ntr_sodium, MassUnit.MILLIGRAM),
    SUGAR_ALCOHOL(R.string.ntr_sugar_alcohol_code, R.string.ntr_sugar_alcohol, MassUnit.GRAM),
    TOTAL_SUGARS(R.string.ntr_sugars_total_code, R.string.ntr_sugars_total, MassUnit.GRAM),
    THIAMIN(R.string.ntr_thiamin_code, R.string.ntr_thiamin, MassUnit.MILLIGRAM),
    TOTAL_FAT(R.string.ntr_total_fat_code, R.string.ntr_total_fat, MassUnit.GRAM),
    VITAMIN_A(R.string.ntr_vitamin_a_code, R.string.ntr_vitamin_a, MassUnit.MICROGRAM),
    VITAMIN_B12(R.string.ntr_vitamin_b12_code, R.string.ntr_vitamin_b12, MassUnit.MICROGRAM),
    VITAMIN_B6(R.string.ntr_vitamin_b6_code, R.string.ntr_vitamin_b6, MassUnit.MILLIGRAM),
    VITAMIN_C(R.string.ntr_vitamin_c_code, R.string.ntr_vitamin_c, MassUnit.MILLIGRAM),
    VITAMIN_D(R.string.ntr_vitamin_d_code, R.string.ntr_vitamin_d, MassUnit.MICROGRAM),
    VITAMIN_E(R.string.ntr_vitamin_e_code, R.string.ntr_vitamin_e, MassUnit.MILLIGRAM),
    VITAMIN_K(R.string.ntr_vitamin_k_code, R.string.ntr_vitamin_k, MassUnit.MICROGRAM),
    WATER(R.string.ntr_water_code, R.string.ntr_water, VolumeUnit.LITER),
    ZINC(R.string.ntr_zinc_code, R.string.ntr_zinc, MassUnit.MILLIGRAM)
}