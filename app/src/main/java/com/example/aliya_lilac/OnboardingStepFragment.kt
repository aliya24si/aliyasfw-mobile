package com.example.aliya_lilac

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class OnboardingStepFragment : Fragment(R.layout.fragment_onboarding_step) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ivLogo = view.findViewById<ImageView>(R.id.ivOnboardingLogo)
        val tvTitle = view.findViewById<TextView>(R.id.tvOnboardingTitle)
        val tvDesc = view.findViewById<TextView>(R.id.tvOnboardingDesc)
        val btnStart = view.findViewById<Button>(R.id.btnStart)

        val title = arguments?.getString("TITLE")
        val desc = arguments?.getString("DESC")
        val imageRes = arguments?.getInt("IMAGE") ?: R.drawable.logo_apps
        val isLastPage = arguments?.getBoolean("IS_LAST") ?: false

        tvTitle.text = title
        tvDesc.text = desc
        ivLogo.setImageResource(imageRes)

        // Tombol hanya muncul di halaman terakhir onboarding
        if (isLastPage) {
            btnStart.visibility = View.VISIBLE
            btnStart.setOnClickListener {
                startActivity(Intent(requireContext(), LoginActivity::class.java))
                requireActivity().finish()
            }
        } else {
            btnStart.visibility = View.GONE
        }
    }

    companion object {
        fun newInstance(title: String, desc: String, imageRes: Int, isLastPage: Boolean): OnboardingStepFragment {
            val fragment = OnboardingStepFragment()
            val args = Bundle().apply {
                putString("TITLE", title)
                putString("DESC", desc)
                putInt("IMAGE", imageRes)
                putBoolean("IS_LAST", isLastPage)
            }
            fragment.arguments = args
            return fragment
        }
    }
}