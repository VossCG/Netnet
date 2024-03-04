package com.example.netnet.model.twse

import com.google.gson.annotations.SerializedName

class TwsePublicBalanceSheet(
    @SerializedName("年度") val year: String,
    @SerializedName("季別") val season: String,
    @SerializedName("出表日期") val releaseDate: String,
    @SerializedName("公司代號") val companyCode: String,
    @SerializedName("公司名稱") val companyName: String,
    @SerializedName("現金及約當現金") val cashAndEquivalents: String,
    @SerializedName("透過損益按公允價值衡量之金融資產") val financialAssetsAtFairValueThroughProfitOrLoss: String,
    @SerializedName("透過其他綜合損益按公允價值衡量之金融資產") val financialAssetsMeasuredAtFairValueThroughOtherComprehensiveIncome: String,
    @SerializedName("按攤銷後成本衡量之債務工具投資") val debtSecuritiesInvestedAtAmortizedCost: String,
    @SerializedName("避險之衍生金融資產淨額") val netDerivativeFinancialAssetsForHedging: String,
    @SerializedName("附賣回票券及債券投資淨額") val netInvestmentInRepurchaseAgreementsAndBonds: String,
    @SerializedName("應收款項－淨額") val accountsReceivableNet: String,
    @SerializedName("當期所得稅資產") val currentIncomeTaxAssets: String,
    @SerializedName("待出售資產－淨額") val assetsHeldForSaleNet: String,
    @SerializedName("待分配予業主之資產－淨額") val assetsHeldForDistributionToOwnersNet: String,
    @SerializedName("貼現及放款－淨額") val loansAndDiscountsNet: String,
    @SerializedName("採用權益法之投資－淨額") val investmentsAccountedForUsingEquityMethodNet: String,
    @SerializedName("受限制資產－淨額") val restrictedAssetsNet: String,
    @SerializedName("其他金融資產－淨額") val otherFinancialAssetsNet: String,
    @SerializedName("不動產及設備－淨額") val propertyAndEquipmentNet: String,
    @SerializedName("使用權資產－淨額") val rightOfUseAssetsNet: String,
    @SerializedName("投資性不動產投資－淨額") val investmentPropertiesNet: String,
    @SerializedName("無形資產－淨額") val intangibleAssetsNet: String,
    @SerializedName("遞延所得稅資產") val deferredIncomeTaxAssets: String,
    @SerializedName("其他資產－淨額") val otherAssetsNet: String,
    @SerializedName("資產總額") val totalAssets: String,
    @SerializedName("央行及銀行同業存款") val depositsWithCentralBanksAndLoansToBanks: String,
    @SerializedName("央行及同業融資") val borrowingFromCentralBanksAndBorrowingFromPeers: String,
    @SerializedName("透過損益按公允價值衡量之金融負債") val financialLiabilitiesAtFairValueThroughProfitOrLoss: String,
    @SerializedName("避險之衍生金融負債－淨額") val netDerivativeFinancialLiabilitiesForHedging: String,
    @SerializedName("附買回票券及債券負債") val repurchaseAgreementsAndBondsPayable: String,
    @SerializedName("應付款項") val accountsPayable: String,
    @SerializedName("當期所得稅負債") val currentIncomeTaxLiabilities: String,
    @SerializedName("與待出售資產直接相關之負債") val liabilitiesDirectlyRelatedToAssetsHeldForSale: String,
    @SerializedName("存款及匯款") val depositsAndRemittances: String,
    @SerializedName("應付金融債券") val financialBondsPayable: String,
    @SerializedName("應付公司債") val corporateBondsPayable: String,
    @SerializedName("特別股負債") val specialStockLiabilities: String,
    @SerializedName("其他金融負債") val otherFinancialLiabilities: String,
    @SerializedName("負債準備") val liabilityReserves: String,
    @SerializedName("租賃負債") val leaseLiabilities: String,
    @SerializedName("遞延所得稅負債") val deferredIncomeTaxLiabilities: String,
    @SerializedName("其他負債") val otherLiabilities: String,
    @SerializedName("負債總額") val totalLiabilities: String,
    @SerializedName("股本") val capitalStock: String,
    @SerializedName("權益─具證券性質之虛擬通貨") val equityCryptocurrencyWithSecuritiesNature: String,
    @SerializedName("資本公積") val capitalSurplus: String,
    @SerializedName("保留盈餘") val retainedEarnings: String,
    @SerializedName("其他權益") val otherEquity: String,
    @SerializedName("庫藏股票") val treasuryStock: String,
    @SerializedName("歸屬於母公司業主之權益合計") val totalEquityAttributableToOwnersOfParentCompany: String,
    @SerializedName("共同控制下前手權益") val equityAttributableToJointVentures: String,
    @SerializedName("合併前非屬共同控制股權") val nonControllingInterestBeforeConsolidation: String,
    @SerializedName("非控制權益") val nonControlEquity: String,
) {
}