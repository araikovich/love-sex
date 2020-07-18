package araikovich.inc.lovesex.ui.sex_positions.dialog

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import araikovich.inc.lovesex.R
import araikovich.inc.lovesex.databinding.DialogPurchaseSexPositionsPackBinding

class PurchaseSexPositionsPackDialog : DialogFragment() {

    private lateinit var binding: DialogPurchaseSexPositionsPackBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.requestFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }

    override fun onResume() {
        super.onResume()
        val window = dialog?.window ?: return
        val params = window.attributes
        params.width = ViewGroup.LayoutParams.MATCH_PARENT
        params.height = ViewGroup.LayoutParams.MATCH_PARENT
        window.attributes = params
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dialog_purchase_sex_positions_pack, container, false)
        binding = DataBindingUtil.bind(view)!!
        return view
    }
}