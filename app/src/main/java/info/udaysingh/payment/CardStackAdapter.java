package info.udaysingh.payment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CardStackAdapter extends ArrayAdapter<OfferCard> {
    public CardStackAdapter(@NonNull Context context, int resource) {
        super(context, 0);
    }

    @Override
    public View getView(int position, View contentView, ViewGroup parent) {
        ViewHolder holder;
        if (contentView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            contentView = inflater.inflate(R.layout.swipe_card, parent, false);
            holder = new ViewHolder(contentView);
            contentView.setTag(holder);
        } else {
            holder = (ViewHolder) contentView.getTag();
        }

        OfferCard offerCard = getItem(position);

        holder.title.setText(offerCard.getTitle());
        holder.subtitle.setText(offerCard.getSubtitle());
        holder.price.setText(offerCard.getPrice());


        return contentView;
    }


        private static class ViewHolder {
        public TextView title;
        public TextView subtitle;
        public TextView price;
        public Button button_save;

        public ViewHolder(View view) {
            this.title = (TextView) view.findViewById(R.id.swipe_card_text);
            this.subtitle = (TextView) view.findViewById(R.id.swipe_card_subtext);
            this.price = (TextView) view.findViewById(R.id.textview_price);
            this.button_save = view.findViewById(R.id.button_save);

        }
    }
}
