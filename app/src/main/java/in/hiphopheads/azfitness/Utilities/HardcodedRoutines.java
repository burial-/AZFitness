package in.hiphopheads.azfitness.Utilities;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import in.hiphopheads.azfitness.Models.Routine;
import in.hiphopheads.azfitness.R;

/**
 * TODO: Use a database, maybe get the data through JSON online or something
 * This is not good programming, this is not good at all
 * Created on 13/10/14.
 */
public class HardcodedRoutines {
    // This list of routines we will use
    private List<Routine> routines = new ArrayList<Routine>();

    public HardcodedRoutines(Context mContext) {
        // Each of these creates a new routine,
        // it also creates an array of image ids which we add to the routine,
        // we then add the routine to the routines list
        int[] routineImages = {R.drawable.a1, R.drawable.a2, R.drawable.a3};
        Routine routine = new Routine(
                mContext.getString(R.string.a_title),
                mContext.getString(R.string.a_desc),
                mContext.getString(R.string.a_letter),
                routineImages);
        routines.add(routine);

        routineImages = new int[]{R.drawable.b1, R.drawable.b2, R.drawable.b3, R.drawable.b4, R.drawable.b5};
        routine = new Routine(
                mContext.getString(R.string.b_title),
                mContext.getString(R.string.b_desc),
                mContext.getString(R.string.b_letter),
                routineImages);
        routines.add(routine);

        routineImages = new int[]{R.drawable.c1, R.drawable.c2, R.drawable.c3};
        routine = new Routine(
                mContext.getString(R.string.c_title),
                mContext.getString(R.string.c_desc),
                mContext.getString(R.string.c_letter),
                routineImages);
        routines.add(routine);

        routineImages = new int[]{R.drawable.d1, R.drawable.d2, R.drawable.d3};
        routine = new Routine(
                mContext.getString(R.string.d_title),
                mContext.getString(R.string.d_desc),
                mContext.getString(R.string.d_letter),
                routineImages);
        routines.add(routine);

        routineImages = new int[]{R.drawable.e1, R.drawable.e2, R.drawable.e3, R.drawable.e4, R.drawable.e5};
        routine = new Routine(
                mContext.getString(R.string.e_title),
                mContext.getString(R.string.e_desc),
                mContext.getString(R.string.e_letter),
                routineImages);
        routines.add(routine);

        routineImages = new int[]{R.drawable.f1, R.drawable.f2, R.drawable.f3};
        routine = new Routine(
                mContext.getString(R.string.f_title),
                mContext.getString(R.string.f_desc),
                mContext.getString(R.string.f_letter),
                routineImages);
        routines.add(routine);

        routineImages = new int[]{R.drawable.g1, R.drawable.g2, R.drawable.g3, R.drawable.g4};
        routine = new Routine(
                mContext.getString(R.string.g_title),
                mContext.getString(R.string.g_desc),
                mContext.getString(R.string.g_letter),
                routineImages);
        routines.add(routine);

        routineImages = new int[]{R.drawable.h1, R.drawable.h2, R.drawable.h3, R.drawable.h4, R.drawable.h5};
        routine = new Routine(
                mContext.getString(R.string.h_title),
                mContext.getString(R.string.h_desc),
                mContext.getString(R.string.h_letter),
                routineImages);
        routines.add(routine);

        routineImages = new int[]{R.drawable.i1, R.drawable.i2, R.drawable.i3};
        routine = new Routine(
                mContext.getString(R.string.i_title),
                mContext.getString(R.string.i_desc),
                mContext.getString(R.string.i_letter),
                routineImages);
        routines.add(routine);

        routineImages = new int[]{R.drawable.j1, R.drawable.j2, R.drawable.j3};
        routine = new Routine(
                mContext.getString(R.string.j_title),
                mContext.getString(R.string.j_desc),
                mContext.getString(R.string.j_letter),
                routineImages);
        routines.add(routine);

        routineImages = new int[]{R.drawable.k1, R.drawable.k2, R.drawable.k3};
        routine = new Routine(
                mContext.getString(R.string.k_title),
                mContext.getString(R.string.k_desc),
                mContext.getString(R.string.k_letter),
                routineImages);
        routines.add(routine);

        routineImages = new int[]{R.drawable.l1, R.drawable.l2, R.drawable.l3};
        routine = new Routine(
                mContext.getString(R.string.l_title),
                mContext.getString(R.string.l_desc),
                mContext.getString(R.string.l_letter),
                routineImages);
        routines.add(routine);

        routineImages = new int[]{R.drawable.m1, R.drawable.m2};
        routine = new Routine(
                mContext.getString(R.string.m_title),
                mContext.getString(R.string.m_desc),
                mContext.getString(R.string.m_letter),
                routineImages);
        routines.add(routine);

        routineImages = new int[]{R.drawable.n1, R.drawable.n2, R.drawable.n3, R.drawable.n4, R.drawable.n5, R.drawable.n6};
        routine = new Routine(
                mContext.getString(R.string.n_title),
                mContext.getString(R.string.n_desc),
                mContext.getString(R.string.n_letter),
                routineImages);
        routines.add(routine);

        routineImages = new int[]{R.drawable.o1, R.drawable.o2, R.drawable.o3};
        routine = new Routine(
                mContext.getString(R.string.o_title),
                mContext.getString(R.string.o_desc),
                mContext.getString(R.string.o_letter),
                routineImages);
        routines.add(routine);

        routineImages = new int[]{R.drawable.p1, R.drawable.p2, R.drawable.p3};
        routine = new Routine(
                mContext.getString(R.string.p_title),
                mContext.getString(R.string.p_desc),
                mContext.getString(R.string.p_letter),
                routineImages);
        routines.add(routine);

        routineImages = new int[]{R.drawable.q1, R.drawable.q2, R.drawable.q3};
        routine = new Routine(
                mContext.getString(R.string.q_title),
                mContext.getString(R.string.q_desc),
                mContext.getString(R.string.q_letter),
                routineImages);
        routines.add(routine);

        routineImages = new int[]{R.drawable.r1, R.drawable.r2, R.drawable.r3};
        routine = new Routine(
                mContext.getString(R.string.r_title),
                mContext.getString(R.string.r_desc),
                mContext.getString(R.string.r_letter),
                routineImages);
        routines.add(routine);

        routineImages = new int[]{R.drawable.s1, R.drawable.s2, R.drawable.s3, R.drawable.s4};
        routine = new Routine(
                mContext.getString(R.string.s_title),
                mContext.getString(R.string.s_desc),
                mContext.getString(R.string.s_letter),
                routineImages);
        routines.add(routine);

        routineImages = new int[]{R.drawable.t1, R.drawable.t2, R.drawable.t3, R.drawable.t4};
        routine = new Routine(
                mContext.getString(R.string.t_title),
                mContext.getString(R.string.t_desc),
                mContext.getString(R.string.t_letter),
                routineImages);
        routines.add(routine);

        routineImages = new int[]{R.drawable.u1, R.drawable.u2, R.drawable.u3};
        routine = new Routine(
                mContext.getString(R.string.u_title),
                mContext.getString(R.string.u_desc),
                mContext.getString(R.string.u_letter),
                routineImages);
        routines.add(routine);

        routineImages = new int[]{R.drawable.v1, R.drawable.v2, R.drawable.v3};
        routine = new Routine(
                mContext.getString(R.string.v_title),
                mContext.getString(R.string.v_desc),
                mContext.getString(R.string.v_letter),
                routineImages);
        routines.add(routine);

        routineImages = new int[]{R.drawable.w1, R.drawable.w2, R.drawable.w3, R.drawable.w4, R.drawable.w5, R.drawable.w6};
        routine = new Routine(
                mContext.getString(R.string.w_title),
                mContext.getString(R.string.w_desc),
                mContext.getString(R.string.w_letter),
                routineImages);
        routines.add(routine);

        routineImages = new int[]{R.drawable.x1, R.drawable.x2, R.drawable.x3};
        routine = new Routine(
                mContext.getString(R.string.x_title),
                mContext.getString(R.string.x_desc),
                mContext.getString(R.string.x_letter),
                routineImages);
        routines.add(routine);

        routineImages = new int[]{R.drawable.y1, R.drawable.y2, R.drawable.y3};
        routine = new Routine(
                mContext.getString(R.string.y_title),
                mContext.getString(R.string.y_desc),
                mContext.getString(R.string.y_letter),
                routineImages);
        routines.add(routine);

        routineImages = new int[]{R.drawable.z1, R.drawable.z2, R.drawable.z3, R.drawable.z4};
        routine = new Routine(
                mContext.getString(R.string.z_title),
                mContext.getString(R.string.z_desc),
                mContext.getString(R.string.z_letter),
                routineImages);
        routines.add(routine);

        // We sort the list by the letter
        if (routines.size() > 0) {
            Collections.sort(routines, new Comparator() {
                @Override
                public int compare(Object o, Object o2) {
                    Routine r1 = (Routine) o;
                    Routine r2 = (Routine) o2;
                    return r1.getLetter().compareTo(r2.getLetter());
                }
            });
        }
    }

    // Basic function to get the list of routines
    public List<Routine> getRoutines() {
        return routines;
    }

    public int getRoutineListLength() {
        return routines.size();
    }
}
