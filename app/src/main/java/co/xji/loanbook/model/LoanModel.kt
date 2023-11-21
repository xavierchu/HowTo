package co.xji.loanbook.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LoanModel(
    val id: Int,
    val name: String,
    val interestRate: Double,
    val amount: Double,
    val duration: Int,
    val fees: Double,
    val imageUrl: String
) : Parcelable